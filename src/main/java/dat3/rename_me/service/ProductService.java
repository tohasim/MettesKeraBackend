package dat3.rename_me.service;

import dat3.rename_me.dto.ProductResponse;
import dat3.rename_me.entity.Product;
import dat3.rename_me.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            productResponses.add(getProduct(product.getId(), false));
        }
        return productResponses;

    }

    public ProductResponse getProduct(Integer id, boolean includeDetails) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product with this id not found"));
        return new ProductResponse(product, includeDetails);
    }
/*
    public Product getProductByName(String name) {
        return productRepository.findById().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

   /* public Product getProductByName(String name) {
       return productRepository.findById(name)Throw(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

    }
*/
}
