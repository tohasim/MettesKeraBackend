package dat3.MetteKera.dto;

import dat3.MetteKera.entity.Category;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryRequest {
    String name;

    public static Category getCategoryEntity(CategoryRequest categoryRequest){
        return new Category(categoryRequest.getName());
    }



    public static CategoryRequest getCategory(Category category) {
        return new CategoryRequest(category.getName());
    }
}
