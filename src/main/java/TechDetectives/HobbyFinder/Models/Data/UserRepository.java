package TechDetectives.HobbyFinder.Models.Data;


import TechDetectives.HobbyFinder.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

    User findByUsername(String username);
}
