package TechDetectives.HobbyFinder.Models.Data;

import TechDetectives.HobbyFinder.Models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository {
    public interface CategoryRepository extends CrudRepository<Category, Integer> {
        Iterable<Category>findAllOrderByName(String name);
    }
}
