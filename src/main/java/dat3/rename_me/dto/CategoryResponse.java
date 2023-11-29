package dat3.rename_me.dto;
import dat3.rename_me.entity.Category;
import lombok.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {
    private int id;
    private String name;

    public CategoryResponse(Category c) {
        this.id = c.getId();
        this.name = c.getName();
    }
}
