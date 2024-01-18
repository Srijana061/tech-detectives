package TechDetectives.HobbyFinder.Controllers;

import TechDetectives.HobbyFinder.Models.Category;
import TechDetectives.HobbyFinder.Models.Data.CategoryRepository;
import TechDetectives.HobbyFinder.Models.Data.SurveyRepository;
import TechDetectives.HobbyFinder.Models.Data.UserRepository;
import TechDetectives.HobbyFinder.Models.Survey;
import TechDetectives.HobbyFinder.Models.User;
import TechDetectives.HobbyFinder.Models.dto.LoginFormDTO;
import TechDetectives.HobbyFinder.Models.dto.RegisterFormDTO;
import TechDetectives.HobbyFinder.Models.dto.SurveyFormDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    SurveyRepository surveyRepository;

    private static final String userSessionKey = "user";

    public User getUserFromSession (HttpSession session){
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null){
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty()) {
            return null;
        }
        return user.get();
    }

    private static void setUserInSession (HttpSession session, User user){
        session.setAttribute(userSessionKey, user.getId());
    }

    @GetMapping("/register")
    public String displayRegistrationForm(Model model){
        model.addAttribute(new RegisterFormDTO());
        model.addAttribute("title","Register");
        return "register";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO,
                                          Errors errors, HttpServletRequest request, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title","Register");
            return "register";
        }

        User existingUser = userRepository.findByUsername(registerFormDTO.getUsername());

        if(existingUser != null){
            errors.rejectValue("username","username.alreadyexists","A " +
                    "user with that username already exists");
            model.addAttribute("title","register");
            return "register";
        }

        String password = registerFormDTO.getPassword();
        String verifyPassword = registerFormDTO.getVerifyPassword();

        if(!password.equals(verifyPassword)){
            errors.rejectValue("password","password.mismatch","Passwords do not match");
            model.addAttribute("title","Register");
            return "register";
        }

        User newUser = new User(registerFormDTO.getUsername(),registerFormDTO.getPassword());
        userRepository.save(newUser);
        setUserInSession(request.getSession(),newUser);

        return "redirect:/survey";
    }

    @GetMapping("/login")
    public String displayLoginForm(Model model){
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title","Log In");
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,Errors errors,
                                   HttpServletRequest request, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title","Log In");
            return "login";
        }

        User theUser = userRepository.findByUsername(loginFormDTO.getUsername());

        if(theUser == null){
            errors.rejectValue("username","user.valid","The given username does not exist");
            model.addAttribute("title","Log In");
            return "login";
        }

        String password = loginFormDTO.getPassword();

        if(!theUser.isMatchingPassword(password)){
            errors.rejectValue("password","password.invalid","Invalid Password");
            model.addAttribute("title","Log In");
            return "login";
        }

        setUserInSession(request.getSession(), theUser);

        return "redirect:";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login";
    }

    @GetMapping("/survey")
    public String displaySurveyForm (Model model) {
        List categories = (List<Category>) categoryRepository.findAll();

        if(categories.size() > 20){
            categories = categories.subList(0,20);
        }

        model.addAttribute("title","Sign Up Survey");
        model.addAttribute("categories", categories);
        model.addAttribute(new SurveyFormDTO());
        return "survey";
    }

    @PostMapping("/survey")
    public String processSurveyForm (@Valid SurveyFormDTO surveyFormDTO, Errors errors, Model model,
                                     HttpServletRequest request){
        List categories = (List<Category>) categoryRepository.findAll();

        if(categories.size() > 20){
            categories = categories.subList(0,20);
        }
        if(errors.hasErrors()){
            model.addAttribute("categories", categories);
            model.addAttribute("title","Sign Up Survey");
            return "survey";
        }

        User currentUser = getUserFromSession(request.getSession());
        Survey surveyResults = new Survey(surveyFormDTO.getInterest1(),surveyFormDTO.getInterest2(),surveyFormDTO.getInterest3(),
                surveyFormDTO.getLocation(),currentUser);
        surveyRepository.save(surveyResults);

        return "redirect:";
    }
}
