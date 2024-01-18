package TechDetectives.HobbyFinder.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Survey extends UserAbstractEntity{

    private String interest1;

    private String interest2;

    private String interest3;

    private String location;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    public Survey(){}

    public Survey(String interest1,String interest2,String interest3,String location,User user_id){
        this.interest1 = interest1;
        this.interest2 = interest3;
        this.interest3 = interest2;
        this.location = location;
        this.user_id = user_id;
    }

    public String getInterest1() {
        return interest1;
    }

    public void setInterest1(String interest1) {
        this.interest1 = interest1;
    }

    public String getInterest2() {
        return interest2;
    }

    public void setInterest2(String interest2) {
        this.interest2 = interest2;
    }

    public String getInterest3() {
        return interest3;
    }

    public void setInterest3(String interest3) {
        this.interest3 = interest3;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
