import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMap {

    static class Product {
        int id;
        String name;
        double price;

        public Product(int id, String name, float price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<>();
        productsList.add(new Product(1, "HP Laptop", 25000));
        productsList.add(new Product(2, "Dell Laptop", 30000));
        productsList.add(new Product(3, "Lenevo Laptop", 28000));
        productsList.add(new Product(4, "Sony Laptop", 28000));
        productsList.add(new Product(5, "Apple Laptop", 90000));

        // Get list of product names
        List<String> names = productsList.stream()
                .map(product -> product.name)
                .collect(Collectors.toList());
        System.out.println(String.format("Product Names : %s", names));

        // List to Set
        Set<Double> priceSet = productsList.stream()
                .map(product -> product.price)
                .collect(Collectors.toSet());
        System.out.println(priceSet);

        // List to Map
        Map<Integer, Double> productMap = productsList.stream()
                .collect(Collectors.toMap(product -> product.id, product -> product.price));
        System.out.println(productMap);

    }
}
