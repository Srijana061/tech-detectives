package TechDetectives.HobbyFinder.Models.Data;

import TechDetectives.HobbyFinder.Models.Survey;
import TechDetectives.HobbyFinder.Models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SurveyRepository extends CrudRepository<Survey,Integer> {

    Survey findByUserId(User userId);


}
