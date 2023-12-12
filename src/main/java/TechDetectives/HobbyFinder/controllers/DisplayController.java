package TechDetectives.HobbyFinder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DisplayController {
    @GetMapping("/")

    public String renderHomePage(Model model) {
        model.addAttribute("headingText", "Welcome to Hobby Finder");

        return "index" ;
    }

}
