package dat3.rename_me.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryController {
    int id;
    String name;
}
