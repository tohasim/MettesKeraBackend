package dat3.rename_me.service;

import dat3.rename_me.api.CategoryController;
import dat3.rename_me.entity.Category;
import dat3.rename_me.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private List<Category> categories;

    public CategoryService() {
        this.categories = new ArrayList<>();
    }

    public void addCategory(CategoryController categoryController) {
        if (!categoryExists(categoryController.getName())) {
            Category newCategory = CategoryMapper.convertToEntity(categoryController);
            categories.add(newCategory);
            System.out.println("Category added: " + categoryController.getName());
        } else {
            System.out.println("Category already exists: " + categoryController.getName());
        }
    }
    private boolean categoryExists(String categoryName) {
        for (Category category : categories) {
            if (category.getName().equalsIgnoreCase(categoryName)) {
                return true;
            }
        }
        return false;
    }

    private static class CategoryMapper {
        static Category convertToEntity(CategoryController categoryController) {
            return new Category(categoryController.getId(), categoryController.getName());
        }
    }
}

