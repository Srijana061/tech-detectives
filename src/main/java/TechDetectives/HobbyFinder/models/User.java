package TechDetectives.HobbyFinder.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


//An entity represents a table stored in a database. Every instance of an
//entity represents a row in the table. Once the database is set up, this
//annotation can be used.

//@Entity
public class User extends AbstractEntity {

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 30, message = "Username must be 3-30 characters long")
    private String username;

    @NotBlank
    private String pwHash;

    public User() {}

    public User(String username, String password){
        this.username = username;
        this.pwHash = password;
    }

    public String getUsername() {
        return username;
    }
}
