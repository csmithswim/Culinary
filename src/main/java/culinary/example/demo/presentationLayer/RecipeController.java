package culinary.example.demo.presentationLayer;

import culinary.example.demo.businessLayer.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import culinary.example.demo.businessLayer.Recipe;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RecipeController {
    final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/recipe/new")
    public Object postRecipe(@Valid @RequestBody Recipe recipe) {
        Recipe newRecipe = recipeService.save(recipe);
        return String.format("{\"id\": %d}", newRecipe.getId());
    }

    //Need to implement this for stage 4
    @PutMapping("/recipe/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Recipe putRecipe(@Valid @RequestBody Recipe newRecipe, @PathVariable Long id) {
        Recipe recipe = recipeService.findRecipeById(id);
        recipe.setCategory(newRecipe.getCategory());
        recipe.setDate(newRecipe.getDate());
        recipe.setDescription(newRecipe.getDescription());
        recipe.setDirections(newRecipe.getDirections());
        recipe.setName(newRecipe.getName());
        return recipeService.save(recipe);
    }


    @GetMapping("/recipe/{id}")
    public Recipe getRecipe(@PathVariable long id) {
        return recipeService.findRecipeById(id);
    }

    @DeleteMapping("/recipe/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteRecipe(@PathVariable long id) {
        recipeService.deleteRecipeById(id);
    }





}

