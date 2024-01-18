package TechDetectives.HobbyFinder.Controllers;

import TechDetectives.HobbyFinder.Models.Category;
import TechDetectives.HobbyFinder.Models.Data.CategoryRepository;
import TechDetectives.HobbyFinder.Models.Data.HobbyRepository;
import TechDetectives.HobbyFinder.Models.Hobby;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class HobbyController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private HobbyRepository hobbyRepository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("hobbies", hobbyRepository.findAll());
        return "index";

    }

    @GetMapping("add")
    public String displayAddHobbyForm(Model model) {
        model.addAttribute("title", "Add Hobby");
        model.addAttribute(new Hobby());

        List categories = (List<Category>) categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "add";
    }



    @PostMapping("add")
    public String processAddHobbyForm(@ModelAttribute @Valid Hobby newHobby, Errors errors, Model model, @RequestParam int categoryId, @RequestParam("description") String description, @RequestParam("location") String location) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Hobby");

            List categories = (List <Category>) categoryRepository.findAll();

            model.addAttribute("categories", categories);
            return "add";


        }
        Optional<Category> optCategory= categoryRepository.findById(categoryId);

        if(optCategory.isPresent()) {
            Category category = optCategory.get();
            newHobby.setCategory(category);
        }
        hobbyRepository.save(newHobby);
        return "redirect:./";

    }
    @GetMapping("view/{hobbyId}")

    public String displayViewHobby(Model model, @PathVariable int hobbyId) {
        Optional<Hobby> optHobby = hobbyRepository.findById(hobbyId);

        if(optHobby.isPresent()) {
            Hobby hobby = (Hobby) optHobby.get();
            model.addAttribute("hobby", hobby);
            return "view";
        } else {
            return "redirect:./";
        }
    }
}


