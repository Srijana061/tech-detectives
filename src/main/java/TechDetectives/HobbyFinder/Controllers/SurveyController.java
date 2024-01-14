package TechDetectives.HobbyFinder.Controllers;

import TechDetectives.HobbyFinder.Models.Data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SurveyController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/survey")
    public String displaySurveyForm (Model model) {
        model.addAttribute("title","Sign Up");
        return "survey";
    }








}
