package culinary.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RecipeController {

    @Autowired
    private RecipeRepository repository;

    List<Recipe> recipes = new ArrayList<>();


    //Objective 3 GET route
    @GetMapping("api/recipe/{id}")
    public Recipe getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/api/recipe/new")
    public Recipe postRecipe(@RequestBody Recipe recipe) {
        return repository.save(recipe);
    }


}


//@PostMapping("/api/recipe/new")
//public Map<String, Integer> postRecipe(@RequestBody Recipe recipe) {
//    recipes.add(recipe);
//    Map<String, Integer> id = new HashMap<>();
//    id.put("id", recipes.size() - 1);
//    return id;
//}

//    @GetMapping("/api/recipe/{id}")
//    public Recipe getRecipes(@PathVariable int id) {
//        if (id > recipes.size()) {
//            throw new RecipeNotFoundException("recipe not found for id = " + id);
//        }
//        return recipes.get(id);
//
//    }