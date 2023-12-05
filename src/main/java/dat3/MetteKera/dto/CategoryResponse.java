package dat3.MetteKera.dto;
import dat3.MetteKera.entity.Category;
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
