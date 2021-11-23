package culinary.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;
    String name;
    String   description;
    String[] ingredients;
    String[] directions;

    public Recipe() {}

    public Recipe(String name, String description, String[] ingredients, String[] directions) {
        this.name        = name;
        this.description = description;
        this.ingredients = ingredients;
        this.directions  = directions;
    }
}

