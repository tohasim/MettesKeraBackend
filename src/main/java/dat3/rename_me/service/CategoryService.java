package dat3.rename_me.service;

import dat3.rename_me.api.CategoryDTO;
import dat3.rename_me.entity.Category;
import dat3.rename_me.repository.CategoryRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private List<Category> categories;
    private final CategoryRepository categoryRepository;



    public CategoryService(CategoryRepository categoryRepository, List<Category> categories) {
        this.categories = new ArrayList<>();
        this.categoryRepository = categoryRepository;
    }
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public void addCategory(CategoryDTO categoryDTO) {
        if (!categoryExists(categoryDTO.getName())) {
            Category newCategory = CategoryMapper.convertToEntity(categoryDTO);
            categories.add(newCategory);
            System.out.println("Category added: " + categoryDTO.getName());
        } else {
            System.out.println("Category already exists: " + categoryDTO.getName());
        }
    }
    public boolean categoryExists(String categoryName) {
        for (Category category : categories) {
            if (category.getName().equalsIgnoreCase(categoryName)) {
                return true;
            }
        }
        return false;
    }

    private static class CategoryMapper {
        static Category convertToEntity(CategoryDTO categoryDTO) {
            return new Category(categoryDTO.getId(), categoryDTO.getName());
        }
    }
}

