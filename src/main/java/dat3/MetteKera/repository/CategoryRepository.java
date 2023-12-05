package dat3.MetteKera.repository;

import dat3.MetteKera.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Boolean existsByName(String name);
    Optional<Category> findByName(String name);
}
