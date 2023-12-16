package TechDetectives.HobbyFinder.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Category extends AbstractEntity {

    public String location;

    @OneToMany
    @JoinColumn(name = "category_id")
    private final List<Hobby> hobbies = new ArrayList<>();

    public Category() {

    }


    public Category(String location) {
        super();
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}




