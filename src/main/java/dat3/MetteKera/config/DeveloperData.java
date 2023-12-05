package dat3.MetteKera.config;


import dat3.MetteKera.repository.CategoryRepository;
import dat3.MetteKera.repository.ProductRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

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
