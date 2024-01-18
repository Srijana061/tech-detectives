package TechDetectives.HobbyFinder.Models.Data;

import TechDetectives.HobbyFinder.Models.CommentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<CommentModel, Integer> {
}


