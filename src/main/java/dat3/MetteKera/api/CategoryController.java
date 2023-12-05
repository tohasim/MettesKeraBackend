package dat3.MetteKera.api;

import dat3.MetteKera.dto.CategoryRequest;
import dat3.MetteKera.dto.CategoryResponse;
import dat3.MetteKera.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public CategoryResponse addCategory(@RequestBody CategoryRequest categoryRequest) {
        return categoryService.addCategory(categoryRequest);

    }
}
