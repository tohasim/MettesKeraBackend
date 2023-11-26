package dat3.rename_me.repository;


import dat3.rename_me.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    }

