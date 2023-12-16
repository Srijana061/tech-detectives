package TechDetectives.HobbyFinder.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


import java.util.Objects;

@Entity
public class Hobby {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToOne
    private Category category;
    private String location;
    private String description;


    public Hobby() {

    }

    public Hobby(String name, Category aCategory, String location, String description) {

        this.name = name;
        this.category = aCategory;
        this.location = location;
        this.description = description;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hobby hobby = (Hobby) o;
        return id == hobby.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

