package TechDetectives.HobbyFinder.Models;


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