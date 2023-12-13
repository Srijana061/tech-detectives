package TechDetectives.HobbyFinder.models;

import java.util.Objects;

public class Hobby {

    private static int nextId = 1;

    private final int id;
    private String name;
    private String category;
    private String location;
    private String description;

    public Hobby(String name, String category, String location, String description) {
        this.id = nextId;
        this.name = name;
        this.category = category;
        this.location = location;
        this.description = description;
        nextId++;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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
