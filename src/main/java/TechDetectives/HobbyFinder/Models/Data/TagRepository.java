package TechDetectives.HobbyFinder.Models.Data;


import TechDetectives.HobbyFinder.Models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TagRepository extends CrudRepository<Tag, String>{

Tag findByTagIgnoreCase(String tag);

}
