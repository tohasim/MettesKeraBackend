package dat3.rename_me.service;
import dat3.rename_me.dto.CategoryResponse;
import dat3.rename_me.entity.Category;
import dat3.rename_me.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    void getAllCategories() {
        // Arrange
        Category category1 = new Category("Kopper");
        Category category2 = new Category("Kander");

        when(categoryRepository.findAll()).thenReturn(Arrays.asList(category1, category2));

        // Act
        List<CategoryResponse> result = categoryService.getAllCategories();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Kopper", result.get(0).getName());
        assertEquals("Kander", result.get(1).getName());

        verify(categoryRepository, times(1)).findAll();
    }

    /*
    @Test
    void addCategory() {
        // Arrange
        CategoryDTO categoryDTO = new CategoryDTO(3, "Talerken");
        Category categoryEntity = CategoryMapper.convertToEntity(categoryDTO);

        // Act
        categoryService.addCategory(categoryDTO);

        // Assert
        verify(categoryRepository, times(1)).save(categoryEntity);
    }

     */
}
