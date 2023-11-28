package dat3.rename_me.api;
import dat3.rename_me.service.CategoryService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @Test
    void getAllCategories() throws Exception {
        // Arrange
        when(categoryService.getAllCategories()).thenReturn(Arrays.asList(
                new CategoryDTO(1, "Kander"),
                new CategoryDTO(2, "Kopper"),
                new CategoryDTO(3,"ske")
        ));

        // Act & Assert
        mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Kander\"},{\"id\":2,\"name\":\"Kopper\"},{\"id\": 3,\"name\":\"ske\"}]"));
    }



    @Test
    void addCategory_CategoryDoesNotExist() {
        int categoryId = 4;
        CategoryDTO categoryDTO = new CategoryDTO(categoryId, "talerkener");

        categoryService.addCategory(categoryDTO);

        verify(categoryService, times(1)).addCategory(any());
    }

}
