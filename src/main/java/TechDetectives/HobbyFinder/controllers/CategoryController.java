package TechDetectives.HobbyFinder.Controllers;

import TechDetectives.HobbyFinder.Models.Data.CategoryRepository;

import TechDetectives.HobbyFinder.Models.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "All Categories");
        List categories = (List<Category>) categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "categories/index";
    }

    @GetMapping("add")
    public String displayAddCategoryForm(Model model) {
        model.addAttribute(new Category());
        return "categories/add";
    }

    @PostMapping("add")
    public String processAddCategoryForm(@ModelAttribute @Valid Category newCategory, Errors errors, Model model) {
     if(errors.hasErrors()) {
         model.addAttribute("title", "Add Category");
         return "categories/add";
     }
     categoryRepository.save(newCategory);
     return "redirect:";
    }

    @GetMapping ("view/{categoryId}")
    public String displayViewCategory(Model model, @PathVariable int categoryId) {
    Optional<Category> optCategory = categoryRepository.findById(categoryId);
    if(optCategory.isPresent()) {
        Category category = (Category) optCategory.get();
        model.addAttribute("category", category);
        return "categories/view";
    } else {
        return "redirect:../";
    }
    }
}










