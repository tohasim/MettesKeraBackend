package dat3.rename_me.api;

import dat3.rename_me.dto.ProductRequest;
import dat3.rename_me.dto.ProductResponse;
import dat3.rename_me.entity.Product;
import dat3.rename_me.service.AzureStorageService;
import dat3.rename_me.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) { this.productService = productService;}

    @Autowired
    private AzureStorageService azureStorageService; // Service to handle Azure Blob Storage operations
    @GetMapping
    public List<Product> getAllProducts() {
       return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ProductResponse getProductDetailed(@PathVariable Integer id){
        return productService.getProduct(id, true);
    }
    @PostMapping("/addProduct")
    public ResponseEntity<ProductResponse> addProduct(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("type") String type,
            @RequestParam("price") double price,
            @RequestParam(value = "imageUrl", required = false) MultipartFile imageFile) {

        ProductRequest productRequest = new ProductRequest();
        // Set fields in productRequest from the request parameters
        productRequest.setName(name);
        productRequest.setDescription(description);
        productRequest.setType(type);
        productRequest.setPrice(price);

        if (imageFile != null && !imageFile.isEmpty()) {
            // Upload file to Azure Blob Storage and get the URL
            String imageUrl = azureStorageService.uploadFile(imageFile, "container-name"); // Replace "container-name" with your actual container name
            productRequest.setImageUrl(imageUrl); // Set the URL in the ProductRequest
        }


        ProductResponse savedProduct = productService.addProduct(productRequest);
        return ResponseEntity.ok(savedProduct);
    }
}
