package dat3.rename_me.repository;

import dat3.rename_me.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Boolean existsByName(String name);
    Optional<Category> findByName(String name);
}
