package TechDetectives.HobbyFinder.data;

import TechDetectives.HobbyFinder.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Iterable<Category>findAllOrderByName(String name);
}
