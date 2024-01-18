package TechDetectives.HobbyFinder.Models.Data;

import TechDetectives.HobbyFinder.Models.PostModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<PostModel, Integer> {
}


