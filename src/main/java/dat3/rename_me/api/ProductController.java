package dat3.rename_me.api;

import dat3.rename_me.dto.ProductResponse;
import dat3.rename_me.entity.Product;
import dat3.rename_me.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) { this.productService = productService;}


    @GetMapping
    public List<Product> getAllProducts() {
       return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ProductResponse getProductDetailed(@PathVariable Long id){
        return productService.getProduct(id, true);
    }
}
