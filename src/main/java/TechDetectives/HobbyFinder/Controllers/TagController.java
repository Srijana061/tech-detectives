package TechDetectives.HobbyFinder.Controllers;


import TechDetectives.HobbyFinder.Models.Data.PostRepository;
import TechDetectives.HobbyFinder.Models.Data.TagRepository;
import TechDetectives.HobbyFinder.Models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.Optional;


@Controller
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private PostRepository postRepository;

    @RequestMapping("")
    public String listTags(Model model) {
        model.addAttribute("tags", tagRepository.findAll());
        return "tags/index";
    }

    @GetMapping("add")
    public String displayAddTagForm(Model model) {
        model.addAttribute("title", "Create Tag");
        model.addAttribute(new Tag());
        return "tags/add";
    }

    @PostMapping("add")
    public String processAddTagForm(@ModelAttribute @Valid Tag tag, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Tag");
            return "tags/add";
        }
        tagRepository.save(tag);
        return "redirect:/tags";
    }

    @GetMapping("view/{tagId}")
    public String displayViewTag(Model model, @PathVariable int tagId) {
        Optional<Tag> optTag = tagRepository.findById(tagId);
        if (optTag.isPresent()) {
            Tag tag = optTag.get();
            model.addAttribute("tag", tag);
            return "tags/view";
        } else {
            return "redirect:/tags";
        }
    }


}
