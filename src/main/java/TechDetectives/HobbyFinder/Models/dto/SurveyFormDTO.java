package TechDetectives.HobbyFinder.Models.dto;

import jakarta.validation.constraints.Size;

import java.util.List;

public class SurveyFormDTO {

    @Size(max = 3, message = "Select up to 3 interests")
    private List<String> interests;

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }
}
