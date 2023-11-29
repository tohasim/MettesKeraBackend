package dat3.rename_me.repository;

import dat3.rename_me.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Product.ProductImage, Integer> {
}
