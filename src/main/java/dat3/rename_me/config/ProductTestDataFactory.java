package dat3.rename_me.config;



import dat3.rename_me.entity.Product;

import java.util.*;

public class ProductTestDataFactory {



    private static final List<String> danishNames = Arrays.asList(
            "ægget", "Den seje", "Simones ynglings", "cool style thing", "den seje kop-agtige ting", "råt product", "raw style", "klart nok mand", "til mad", "min ynglings"
    );
    private static final List<String> types = Arrays.asList(
            "Lerfad", "Keramikskål", "Vaske", "Tallerken", "Krus", "Drikkeglas", "Skål", "Saucer", "Tekande", "Desserttallerken"
    );

    public static List<Product> generateTestProducts() {
        Random random = new Random();
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            int id = i;
            String name = types.get(random.nextInt(types.size()));
            String type = danishNames.get(random.nextInt(danishNames.size()));
            String description = "Beskrivelse for " + name;
            double price = 100 + (900 * random.nextDouble()); // Random price between 100 and 1000
            String imageUrl = "url_for_" + name;
            int stock = random.nextInt(0, 10);

            Product product = new Product(id, name, type, description, price, imageUrl, stock);
            products.add(product);
        }

        return products;
    }
}
