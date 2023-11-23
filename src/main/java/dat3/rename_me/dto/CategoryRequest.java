package dat3.rename_me.dto;

import dat3.rename_me.entity.Category;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryRequest {
    String name;
    String type;

}
