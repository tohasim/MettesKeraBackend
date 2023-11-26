package dat3.rename_me.service;

import dat3.rename_me.entity.Product;
import dat3.rename_me.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class ProductService extends Product {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

   /* public Product getProductByName(String name) {
       return productRepository.findById(name)Throw(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

    }
*/
}
