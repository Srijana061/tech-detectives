package TechDetectives.HobbyFinder.controllers;

import TechDetectives.HobbyFinder.data.CategoryRepository;
import TechDetectives.HobbyFinder.data.HobbyRepository;
import TechDetectives.HobbyFinder.models.Category;
import TechDetectives.HobbyFinder.models.Hobby;
import TechDetectives.HobbyFinder.models.HobbyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private HobbyRepository hobbyRepository;

    @Autowired
    private CategoryRepository categoryRepository;



    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("category", "Category");


    }

    @RequestMapping("")
    public String list(Model model) {
        List categories = (List<Category>) categoryRepository.findAll();
        model.addAttribute("categories", categories);



        return "list";
    }

    @RequestMapping(value = "hobbies")
    public String listHobbiesByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        List hobbies;
        if (column.toLowerCase().equals("all")){
            hobbies = (List<Hobby>) hobbyRepository.findAll();
            model.addAttribute("hobbies", hobbies);
            model.addAttribute("title", "All Hobbies");
        } else {
            hobbies = HobbyData.findByColumnAndValue(column, value, hobbyRepository.findAll());
            model.addAttribute("title", "Hobbies with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("hobbies", hobbies);

        return "list-hobbies";
    }
}

