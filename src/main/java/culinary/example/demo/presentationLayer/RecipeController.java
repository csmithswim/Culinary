package culinary.example.demo.presentationLayer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import culinary.example.demo.persistanceLayer.RecipeRepository;
import culinary.example.demo.businessLayer.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    @Autowired
    private RecipeRepository repository;

    List<Recipe> recipes = new ArrayList<>();


    //Objective 3 GET route
    @JsonIgnore
    @JsonProperty(value = "id")
    @GetMapping("/{id}")
    public @ResponseBody Recipe getById(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/new")
    public Map<String,Long>  postRecipe(@Valid @RequestBody Recipe recipe) {
        repository.save(recipe);
        long id = recipe.getId();
        return Map.of("id", id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }


}

