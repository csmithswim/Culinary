package culinary.example.demo.persistanceLayer;

import culinary.example.demo.businessLayer.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> { }
