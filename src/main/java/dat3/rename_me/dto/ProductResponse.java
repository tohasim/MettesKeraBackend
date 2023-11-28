package dat3.rename_me.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.rename_me.entity.Product;
import lombok.*;

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
    String imageUrl;



public ProductResponse(Product pr, boolean includeAll){

    this.name = pr.getName();
    this.price = pr.getPrice();
    this.imageUrl = pr.getImageUrl();
    if(includeAll) {
        this.id = pr.getId();
        this.type = pr.getType();
        this.description = pr.getDescription();
    }
}



}
