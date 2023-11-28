package dat3.rename_me.dto;


import dat3.rename_me.entity.Product;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {
    private String type;
    private String name;
    private String description;
    private double price;
    private List<String> imageUrls;

    public static Product productFromProductRequest(ProductRequest pr){

        List<Product.ProductImage> prImages = new ArrayList<>();
        for (String imageUrl : pr.imageUrls) {
            prImages.add(Product.ProductImage.builder().imageUrl(imageUrl).build());
        }

        return Product.builder().type(pr.type).name(pr.name).description(pr.description).images(prImages).price(pr.price).build();
    }
}
