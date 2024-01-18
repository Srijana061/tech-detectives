package TechDetectives.HobbyFinder.Controllers;

import TechDetectives.HobbyFinder.Models.Category;
import TechDetectives.HobbyFinder.Models.Data.CategoryRepository;
import TechDetectives.HobbyFinder.Models.Data.HobbyRepository;
import TechDetectives.HobbyFinder.Models.Data.SurveyRepository;
import TechDetectives.HobbyFinder.Models.Data.UserRepository;
import TechDetectives.HobbyFinder.Models.Hobby;
import TechDetectives.HobbyFinder.Models.Survey;
import TechDetectives.HobbyFinder.Models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class RecommendedPageController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    HobbyRepository hobbyRepository;

    @Autowired
    UserRepository userRepository;

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

    @GetMapping("recommendedPage")
    public String displayRecommendedPage(Model model, HttpServletRequest request){

        User currentUser = getUserFromSession(request.getSession());
        Survey currentUserSurveyData = surveyRepository.findByUserId(currentUser);

        Category interest1 = categoryRepository.findByName(currentUserSurveyData.getInterest1());
        Category interest2 = categoryRepository.findByName(currentUserSurveyData.getInterest2());
        Category interest3 = categoryRepository.findByName(currentUserSurveyData.getInterest3());


        List<Hobby>currentUserLocationHobbies = hobbyRepository.findByLocation(currentUserSurveyData.getLocation());
        List<Hobby> hobbiesOfInterest1 = hobbyRepository.findByCategory(interest1);
        List<Hobby> hobbiesOfInterest2 = hobbyRepository.findByCategory(interest2);
        List<Hobby> hobbiesOfInterest3 = hobbyRepository.findByCategory(interest3);

        model.addAttribute("hobbiesOfInterest1",hobbiesOfInterest1);
        model.addAttribute("hobbiesOfInterest2",hobbiesOfInterest2);
        model.addAttribute("hobbiesOfInterest3",hobbiesOfInterest3);
        model.addAttribute("currentUserLocationHobbies",currentUserLocationHobbies);

        return "recommendedPage";
    }
}
