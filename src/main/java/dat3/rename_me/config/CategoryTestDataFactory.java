package dat3.rename_me.config;

import dat3.rename_me.entity.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    public class CategoryTestDataFactory {

        private static final List<String> categoryNames = Arrays.asList(
                "Krus", "Tallerken", "Bæger", "Vase", "Kopper"
        );

        public static List<Category> generateTestCategories() {
            List<Category> categories = new ArrayList<>();

            for (int i = 0; i < categoryNames.size(); i++) {
                Category category = new Category(i, categoryNames.get(i));
                categories.add(category);
            }

            return categories;
        }
    }


