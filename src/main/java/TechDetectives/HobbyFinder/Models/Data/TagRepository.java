package TechDetectives.HobbyFinder.Models.Data;


import TechDetectives.HobbyFinder.Models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TagRepository extends CrudRepository<Tag, Integer>{

Optional<Tag> findById(Integer id);

}











