package culinary.example.demo.businessLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import culinary.example.demo.persistanceLayer.RecipeRepository;

@Service
public class RecipeService {
    private final RecipeRepository repository;

    @Autowired
    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public Recipe save(Recipe newRecipe) {
        return repository.save(newRecipe);
      }

    public Recipe findRecipeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Recipe not found for id = " + id));
    }

    public void deleteRecipeById(Long id) {
        Recipe recipe = findRecipeById(id);
        repository.delete(recipe);
    }

}
