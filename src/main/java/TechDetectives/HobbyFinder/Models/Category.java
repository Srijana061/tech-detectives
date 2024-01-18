package TechDetectives.HobbyFinder.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends AbstractEntity {

    public String location;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Hobby> hobbies = new ArrayList<>();

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




