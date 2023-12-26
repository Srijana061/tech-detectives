package TechDetectives.HobbyFinder.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


//An entity represents a table stored in a database. Every instance of an
//entity represents a row in the table. Once the database is set up, this
//annotation can be used.

//@Entity
public class User extends AbstractEntity {

    //FIELDS

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 30, message = "Username must be 3-30 characters long")
    private String username;

    @NotBlank
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    //CONSTRUCTORS

    public User() {}

    public User(String username, String password){
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    //METHODS

    public boolean isMatchingPassword(String password){
        return encoder.matches(password,pwHash);
    }

    public String getUsername() {
        return username;
    }
}
