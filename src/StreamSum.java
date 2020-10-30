import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSum {

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

        // sum
        Double sum = productsList.stream()
                .collect(Collectors.summingDouble(p -> p.price));
        System.out.println(sum);

        // Count
        long count = productsList.stream()
                .filter(product -> product.price >= 30000)
                .count();
        System.out.println(count);


    }
}
