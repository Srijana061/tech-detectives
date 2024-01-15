package TechDetectives.HobbyFinder.Controllers;

import TechDetectives.HobbyFinder.Models.Category;
import TechDetectives.HobbyFinder.Models.Data.CategoryRepository;
import TechDetectives.HobbyFinder.Models.Data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class SurveyController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/survey")
    public String displaySurveyForm (Model model) {
        List categories = (List<Category>) categoryRepository.findAll();

        if(categories.size() > 10){
            categories = categories.subList(0,10);
            Collections.shuffle(categories);
        }

        model.addAttribute("title","Sign Up Survey");
        model.addAttribute("categories", categories);
        return "survey";
    }

    @PostMapping("/survey")
    public String processSurveyForm (){
        return "survey";

    }








}
