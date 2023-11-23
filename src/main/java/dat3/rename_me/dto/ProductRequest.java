package dat3.rename_me.dto;


import dat3.rename_me.entity.Product;
import lombok.*;

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
    private String imageUrl;

    public static Product productFromProductRequest(ProductRequest pr){
        return Product.builder().type(pr.type).name(pr.name).description(pr.description).price(pr.price).imageUrl(pr.imageUrl).build();
    }
}
