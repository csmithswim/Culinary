package culinary.example.demo.persistanceLayer;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import culinary.example.demo.businessLayer.Recipe;


@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}