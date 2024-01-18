package TechDetectives.HobbyFinder.Controllers;

import TechDetectives.HobbyFinder.Models.Category;
import TechDetectives.HobbyFinder.Models.CommentModel;
import TechDetectives.HobbyFinder.Models.Data.CommentRepository;
import TechDetectives.HobbyFinder.Models.Data.PostRepository;
import TechDetectives.HobbyFinder.Models.Hobby;
import TechDetectives.HobbyFinder.Models.PostModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("comments")
@Controller
class CommentsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;


    @GetMapping("add/{postId}")
    public String displayAddCommentForm(Model model, @PathVariable int postId) {
        model.addAttribute(new CommentModel());
        Optional<PostModel> optPost = postRepository.findById(postId);
        if(optPost.isPresent()) {
            PostModel post = (PostModel) optPost.get();
            model.addAttribute("post", post);
            return "comments/add";
        } else {
            return "redirect:posts/view/";
        }
    }

    @PostMapping("add/{postId}")
    public String processAddCommentForm(@ModelAttribute @Valid CommentModel newComment, Errors errors, Model model, @PathVariable("postId") int postId, @RequestParam("body") String body, @RequestParam("name") String name) {

        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Comment");
            return "comments/add";
        }
        Optional<PostModel> optPost = postRepository.findById(postId);
        if(optPost.isPresent()) {
            PostModel post = (PostModel) optPost.get();
            newComment.setPost(post);
        }
        commentRepository.save(newComment);
        return "redirect:/posts/view/" + postId;
    }

}
