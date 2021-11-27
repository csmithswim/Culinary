package culinary.example.demo.persistanceLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import culinary.example.demo.businessLayer.Recipe;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    @Query("select r from Recipe r where lower(r.category) like lower(?1) order by r.date desc")
    List<Recipe> findByCategory(String category);
    List<Recipe> findByCategoryLikeIgnoreCaseOrderByDateDesc(String category);

    @Query("select r from Recipe r where lower(r.name) like lower(concat('%',?1,'%')) order by r.date desc")
    List<Recipe> findByName(String name);
    List<Recipe> findByNameContainingIgnoreCaseOrderByDateDesc(String name);
}