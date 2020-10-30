import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class StreamFilter {
    static class Product {
        int id;
        String name;
        double price;

        private Product(int id, String name, float price) {
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


        // Get prices >= 30000 names
        List<String> prices = productsList
                .stream() // create stream
                .filter(product -> product.price >= 30000) // intermediate
                .map(product -> product.name) // intermediate
                .collect(Collectors.toList()); // terminal
        System.out.println(format("prices %s", prices));

        List<String> list = productsList.stream()
                .map(product -> product.name)
                .filter(p -> p.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(format("my list %s", list));

        // print prices >= 30000
        productsList.stream()
                .filter(product -> product.price > 3000)
                .forEach(product -> System.out.println(product.price));

        // find first where prices >= 25000
        Product product1 = productsList.stream()
                .filter(product -> product.price >= 25000)
                .findAny().orElse(null);
        System.out.println(format("product1 >= 30000 = %f", product1.price));

        List<Double> collect = productsList.stream()
                .filter(product -> product.price > 3000)
                .limit(3)
                .map(product -> product.price)
                .collect(Collectors.toList());
        System.out.println("Limit 3 = " + collect);
    }
}
