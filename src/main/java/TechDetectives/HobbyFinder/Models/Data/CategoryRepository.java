package TechDetectives.HobbyFinder.Models.Data;

import TechDetectives.HobbyFinder.Models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
        Iterable<Category>findAllOrderByName(String name);

        Category findByName(String name);

        //List<Category> findAllByLocationNotNull();


    }

