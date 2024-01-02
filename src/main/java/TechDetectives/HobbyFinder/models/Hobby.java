package TechDetectives.HobbyFinder.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


import java.util.Objects;

@Entity
public class Hobby extends AbstractEntity {

    @ManyToOne
    private Category category;
    private String description;
    private String location;


    public Hobby() {

    }

    public Hobby(Category aCategory) {
        super();
        this.category = aCategory;

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

