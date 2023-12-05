package dat3.MetteKera.repository;

import dat3.MetteKera.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Product.ProductImage, Integer> {
}
