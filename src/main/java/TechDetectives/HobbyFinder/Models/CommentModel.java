package TechDetectives.HobbyFinder.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class CommentModel extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostModel post = new PostModel();

    @NotBlank(message = "Body is required")
    @Size(min = 3, max = 200, message = "Body must be between 3 and 200 characters")
    private String body;

    public CommentModel() {

    }


    public CommentModel(String body) {
        super();
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public PostModel getPost() {
        return post;
    }

    public void setPost(PostModel post) {
        this.post = post;
    }
}