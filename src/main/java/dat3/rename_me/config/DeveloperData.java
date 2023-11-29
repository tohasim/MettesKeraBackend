package dat3.rename_me.config;


import dat3.Application;
import dat3.rename_me.entity.Category;
import dat3.rename_me.entity.Product;
import dat3.rename_me.repository.CategoryRepository;
import dat3.rename_me.repository.ProductRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DeveloperData implements ApplicationRunner {

    ProductRepository productRepository;
   CategoryRepository categoryRepository;

    public DeveloperData(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Category> categories = CategoryTestDataFactory.generateTestCategories();
        categoryRepository.saveAll(categories);

        List<Product> products = ProductTestDataFactory.generateTestProducts();
        productRepository.saveAll(products);
        Product.ProductImage image1 = Product.ProductImage.builder()
                .imageUrl("https://grene-prod-omni.azureedge.net/catalog/159479-1-513222-002_pack_a.png?format=webp&width=640&height=853&quality=80&mode=crop&bgcolor=faf7f0")
                .build();

        Product.ProductImage image2 = Product.ProductImage.builder()
                .imageUrl("https://juliedamhus.dk/media/products/unnamed-19-1.jpg")
                .build();

        Product product1 = Product.builder()
                .name("Sej skål")
                .category("Skål")
                .description("Lækker skål med sejt design")
                .price(350.00)
                .stock(10)
                .images(Arrays.asList(image1, image2))
                .build();
        image1.setProduct(product1);
        image2.setProduct(product1);
        productRepository.save(product1);

    }
}
