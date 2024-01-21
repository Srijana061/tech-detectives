package TechDetectives.HobbyFinder.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tag {


@Id
    private String tag;


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
