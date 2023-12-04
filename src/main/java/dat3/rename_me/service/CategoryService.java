package dat3.rename_me.service;

import dat3.rename_me.dto.CategoryRequest;
import dat3.rename_me.dto.CategoryResponse;
import dat3.rename_me.entity.Category;
import dat3.rename_me.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;



    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryResponse::new)
                .collect(Collectors.toList());
    }

    public CategoryResponse addCategory(CategoryRequest categoryDTO) {
        if (!categoryRepository.existsByName(categoryDTO.getName())) {
            Category newCategory = CategoryRequest.getCategoryEntity(categoryDTO);
            return new CategoryResponse(categoryRepository.save(newCategory));
        } else {
            return null;
        }
    }

    public Category getCategory(String category) {
        return categoryRepository.findByName(category).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category with this name not found"));
    }
}

