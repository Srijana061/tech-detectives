package TechDetectives.HobbyFinder.Models;


import jakarta.validation.constraints.NotNull;

public class CommentModel{
    @NotNull
    private String commentBody;



    @NotNull
    private Long postId;