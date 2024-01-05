package TechDetectives.HobbyFinder.models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public class CommentModel{
    @NotNull
    private String commentBody;



    @NotNull
    private Long postId;


    @GeneratedValue
    @Id
    private Long commentId;


    @NotNull
    private String username;

    public @NotNull String CommentModel () {
    return commentBody;
    }
}