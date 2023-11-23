package dat3.rename_me.config;


import dat3.Application;
import dat3.rename_me.entity.Product;
import dat3.rename_me.repository.ProductRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DeveloperData {

    ProductRepository productRepository;

    public DeveloperData(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

   // @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Product> products = ProductTestDataFactory.generateTestProducts();
        productRepository.saveAll(products);

        Product product1 = Product.builder()
                .name("Sej skål")
                .type("Skål")
                .description("Lækker skål med sejt design")
                .price(350.00)
                .imageUrl("https://grene-prod-omni.azureedge.net/catalog/159479-1-513222-002_pack_a.png?format=webp&width=640&height=853&quality=80&mode=crop&bgcolor=faf7f0")
                .build();

        productRepository.save(product1);

    }
}
