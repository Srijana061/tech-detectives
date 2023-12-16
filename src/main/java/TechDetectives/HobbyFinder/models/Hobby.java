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


}

