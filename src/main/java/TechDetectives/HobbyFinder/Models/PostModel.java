package TechDetectives.HobbyFinder.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PostModel extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "hobby_id")
    private Hobby hobby = new Hobby();

    @OneToMany
    @JoinColumn(name = "post_id")
    private List<CommentModel> comments = new ArrayList<>();

    @NotBlank(message = "Body is required")
    @Size(min = 3, max = 200, message = "Body must be between 3 and 200 characters")
    private String body;

    public PostModel() {

    }


    public PostModel(String body) {
        super();
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public List<CommentModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }
}

/*
TODO:
Update HTML Files for viewing posts, and adding posts via a form
Updating posts to find all comments by post id

Update Comments html add file to create a comment via a form


randomizer button to find random hobby,
will probably be in thymleaf hobbies page, just make a button that randomizes number and use it to grab via GET/hobby/{hobbyid}
 */