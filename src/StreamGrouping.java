import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamGrouping {

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
        productsList.add(new Product(1, "HP Laptop", 15000));
        productsList.add(new Product(2, "Dell Laptop", 30000));
        productsList.add(new Product(3, "Lenevo Laptop", 28000));
        productsList.add(new Product(4, "Sony Laptop", 28000));
        productsList.add(new Product(5, "Apple Laptop", 90000));

        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");
        Map<String, Long> groupByCount = items.stream()
                .collect(Collectors.groupingBy(new Function<String, String>() {
                    @Override
                    public String apply(String p) {
                        return p;
                    }
                }, Collectors.counting()));
        System.out.println("groupByCount = " + groupByCount);

        Map<String, Long> collect = productsList.stream()
                .collect(Collectors.groupingBy(new Function<Product, String>() {
                    @Override
                    public String apply(Product p) {
                        return p.name;
                    }
                }, Collectors.counting()));
        System.out.println(collect);
    }
}
