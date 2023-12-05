package dat3.MetteKera.api;

import dat3.MetteKera.dto.ProductRequest;
import dat3.MetteKera.dto.ProductResponse;
import dat3.MetteKera.service.AzureStorageService;
import dat3.MetteKera.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) { this.productService = productService;}

    @Autowired
    private AzureStorageService azureStorageService; // Service to handle Azure Blob Storage operations
    @GetMapping
    public List<ProductResponse> getAllProducts() {
       return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponse getProductDetailed(@PathVariable Integer id){
        return productService.getProduct(id, true);
    }

    @GetMapping("/detailed")
    public List<ProductResponse> getAllProductsDetails() {return productService.getAllProductsDetails();
    }

    @PostMapping("/addProduct")
    public ResponseEntity<ProductResponse> addProduct(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("category") String category,
            @RequestParam("price") double price,
            @RequestParam(value = "imageFiles", required = false) List<MultipartFile> imageFiles) {

        ProductRequest productRequest = new ProductRequest();
        // Set fields in productRequest from the request parameters
        productRequest.setName(name);
        productRequest.setDescription(description);
        productRequest.setCategory(category);
        productRequest.setPrice(price);

        if (imageFiles != null && !imageFiles.isEmpty()) {
            List<String> imageUrls = new ArrayList<>();
            for (MultipartFile imageFile : imageFiles) {
                // Upload file to Azure Blob Storage and get the URL, categorized by their category and name
                imageUrls.add(azureStorageService.uploadFile(imageFile, String.format("%s/%s", category, name)));
            }
            productRequest.setImageUrls(imageUrls); // Set the URL in the ProductRequest
        }


        ProductResponse savedProduct = productService.addProduct(productRequest);
        return ResponseEntity.ok(savedProduct);
    }
}
