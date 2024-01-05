package TechDetectives.HobbyFinder.Controllers;

import TechDetectives.HobbyFinder.Models.Data.HobbyRepository;
import TechDetectives.HobbyFinder.Models.Hobby;
import TechDetectives.HobbyFinder.Models.HobbyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static TechDetectives.HobbyFinder.Controllers.ListController.columnChoices;


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
        model.addAttribute("title", "Hobbies  " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("hobbies", hobbies);

        return "search";
    }
}

