package culinary.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecipeController {

    List<Recipe> recipes = new ArrayList<>();

    @PostMapping("/api/recipe")
    public int postRecipe(@RequestBody Recipe recipe) {
        recipes.add(recipe);
        return recipes.size() - 1;
    }

    @GetMapping("/api/{id}")
    Recipe getRecipes(@PathVariable int id) {
        return recipes.get(id - 1);
    }


}
