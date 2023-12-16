package TechDetectives.HobbyFinder.controllers;

import TechDetectives.HobbyFinder.data.HobbyRepository;
import TechDetectives.HobbyFinder.models.Hobby;
import TechDetectives.HobbyFinder.models.HobbyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static TechDetectives.HobbyFinder.controllers.ListController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private HobbyRepository hobbyRepository;

    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }



    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Hobby> hobbies;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            hobbies = hobbyRepository.findAll();
        } else {
            hobbies = HobbyData.findByColumnAndValue(searchType, searchTerm, hobbyRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Hobbies with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("hobbies", hobbies);

        return "search";
    }
}

