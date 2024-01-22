package TechDetectives.HobbyFinder.Controllers;

import TechDetectives.HobbyFinder.Models.Category;
import TechDetectives.HobbyFinder.Models.Data.HobbyRepository;
import TechDetectives.HobbyFinder.Models.Data.PostRepository;
import TechDetectives.HobbyFinder.Models.Data.CommentRepository;

import TechDetectives.HobbyFinder.Models.PostModel;
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
@RequestMapping("posts")
class PostsController {

    @Autowired
    private HobbyRepository hobbyRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("Posts", postRepository.findAll());
        return "posts/index";
    }

    @GetMapping("add")
    public String displayAddPostForm(Model model) {
        model.addAttribute("title", "Create Post");
        System.out.println();
        model.addAttribute(new PostModel());
        List hobbies = (List<Hobby>) hobbyRepository.findAll();
        model.addAttribute("hobbies", hobbies);
        return "posts/add";
    }

    @PostMapping("add")
    public String processAddPostsForm(@ModelAttribute @Valid PostModel post, Errors errors, Model model, @RequestParam int hobbyId, @RequestParam("body") String body, @RequestParam("name") String name) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Post");

            List hobbies = (List<Hobby>) hobbyRepository.findAll();
            model.addAttribute("hobbies", hobbies);
            return "posts/add";
        }
        Optional<Hobby> optHobby = hobbyRepository.findById(hobbyId);

        if(optHobby.isPresent()) {
            Hobby hobby = optHobby.get();
            post.setHobby(hobby);
        }

        postRepository.save(post);
        return "redirect:";
    }

    @GetMapping ("view/{postId}")
    public String displayViewPost(Model model, @PathVariable int postId) {
        Optional<PostModel> optPost = postRepository.findById(postId);
        // ALSO NEED TO GET ALL COMMENTS VIA POST ID
        // LIKE Optional<ArrayList<CommentModel> optComments = commentRepository.findByPostid();
        // that find by post id function needs to be added to postrepository
        if(optPost.isPresent()) {
            PostModel post = (PostModel) optPost.get();
            model.addAttribute("post", post);
            return "posts/view";
        } else {
            return "redirect:../";
        }
    }
}

