package TechDetectives.HobbyFinder.Models.Data;

import TechDetectives.HobbyFinder.Models.Category;
import TechDetectives.HobbyFinder.Models.Hobby;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HobbyRepository extends CrudRepository<Hobby, Integer> {

    List <Hobby> findByCategory(Category category);
}


