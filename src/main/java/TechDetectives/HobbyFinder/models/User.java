package TechDetectives.HobbyFinder.Models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


//An entity represents a table stored in a database. Every instance of an
//entity represents a row in the table. Once the database is set up, this
//annotation can be used.

@Entity
public class User extends UserAbstractEntity {

    //FIELDS

    @NotNull
    private String username;

    @NotNull
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
