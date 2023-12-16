package TechDetectives.HobbyFinder.data;


import TechDetectives.HobbyFinder.models.Hobby;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobbyRepository extends CrudRepository<Hobby, Integer> {
}
