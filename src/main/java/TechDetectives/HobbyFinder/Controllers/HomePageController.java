package TechDetectives.HobbyFinder.Controllers;

import TechDetectives.HobbyFinder.Models.Data.HobbyRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


    @Controller
    public class HomePageController {
        @Autowired
        private HobbyRepository hobbyRepository;
        // Corresponds to http://localhost:8080
        @GetMapping("/")
        public String redirectToHomePage() {return "redirect:/welcome";}

        @GetMapping("/welcome")
        public String displayHomePage(Model model, HttpSession session) {
            model.addAttribute("loggedIn", session.getAttribute("user"));
            model.addAttribute("hobbies", hobbyRepository.findAll());
            return "homepage";
        }
    }

