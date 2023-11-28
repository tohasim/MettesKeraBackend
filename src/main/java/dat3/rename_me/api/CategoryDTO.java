package dat3.rename_me.api;

import dat3.rename_me.entity.Category;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private int id;
    private String name;


    public static CategoryDTO fromEntity(Category category) {
        return new CategoryDTO(category.getId(), category.getName());

    }
}

