package dat3.test;

import dat3.rename_me.config.ProductTestDataFactory;
import dat3.rename_me.entity.Product;
import dat3.rename_me.repository.ProductRepository;
import dat3.rename_me.service.ProductService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    private Product product1;


    @BeforeEach()
    void setUp() {
        product1 = Product.builder()
                .name("Sej skål")
                .type("Skål")
                .description("Lækker skål med sejt design")
                .price(350.00)
                .imageUrl("https://grene-prod-omni.azureedge.net/catalog/159479-1-513222-002_pack_a.png?format=webp&width=640&height=853&quality=80&mode=crop&bgcolor=faf7f0")
                .build();  }
    @Test
    void getAllProducts() {
        when(productRepository.findAll()).thenReturn(List.of(product1));
        List<Product> products = productService.getAllProducts();

        assertEquals(1, products.size());
        assertNull();

    }


}
