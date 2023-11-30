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
        ProductTestDataFactory factory = new ProductTestDataFactory(categoryRepository, productRepository);
        factory.generateTestProducts();

    }
}
