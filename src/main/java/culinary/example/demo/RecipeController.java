package culinary.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecipeController {

    List<Recipe> recipes = new ArrayList<>();

    @PostMapping("/api/recipe")
    public List<Recipe> postRecipe(@RequestBody Recipe recipe) {
        recipes.add(recipe);
        return recipes;
    }

    @GetMapping("/api/recipe")
    Recipe getRecipes() {
        return recipes.get(recipes.size() - 1);
    }


}
