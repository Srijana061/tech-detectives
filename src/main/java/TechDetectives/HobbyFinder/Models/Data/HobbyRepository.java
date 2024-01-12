package TechDetectives.HobbyFinder.Models.Data;

import TechDetectives.HobbyFinder.Models.Hobby;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobbyRepository extends CrudRepository<Hobby, Integer> {
}


