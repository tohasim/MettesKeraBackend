package dat3.rename_me.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.rename_me.entity.Product;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) //This is important since we can have to responses, one which includes all (detailed view) and one where only the info necessary for a product is sent.
public class ProductResponse {

    int id;
    String name;
    String type;
    String description;
    Double price;
    List<String> imageUrls;



public ProductResponse(Product pr, boolean includeAll){

    this.name = pr.getName();
    this.price = pr.getPrice();
    this.imageUrls = pr.getImages().stream().map(Product.ProductImage::getImageUrl).collect(Collectors.toList());
    if(includeAll) {
        this.id = pr.getId();
        this.type = pr.getType();
        this.description = pr.getDescription();
    }
}



}
