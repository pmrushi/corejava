import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSort {

    static class Product {
        int id;
        String name;
        double price;

        public Product(int id, String name, float price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return String.format("Product{id=%d, name=%s, price=%f}", id, name, price);
            /*return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';*/
        }
    }

    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<>();
        productsList.add(new Product(1, "HP Laptop", 25000));
        productsList.add(new Product(2, "Dell Laptop", 30000));
        productsList.add(new Product(3, "Lenevo Laptop", 28000));
        productsList.add(new Product(4, "Sony Laptop", 28000));
        productsList.add(new Product(5, "Apple Laptop", 90000));

/*
        Stream<Product> productsStream = Stream.of(
                new Product(1, "HP Laptop", 25000),
                new Product(2, "Dell Laptop", 30000),
                new Product(3, "Lenevo Laptop", 28000),
                new Product(4, "Sony Laptop", 28000),
                new Product(5, "Apple Laptop", 90000)
        );
*/

        List<String> list = Arrays.asList("9", "A", "Z", "1", "B", "Y", "4", "a", "c");
		List<String> sortedList = list.stream()
			.sorted(Comparator.naturalOrder())
			.collect(Collectors.toList());
        System.out.println("sortedList = " + sortedList);

        List<String> sortedList3 = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("sortedList3 reverse = " + sortedList3);

        List<String> sortedList1 = list.stream()
			.sorted((o1,o2)-> o1.compareTo(o2))
			.collect(Collectors.toList());
        System.out.println("sortedList1 = " + sortedList1);

        List<String> sortedList2 = list.stream().sorted().collect(Collectors.toList());
        System.out.println("sortedList2 = " + sortedList2);

        // products sorting
        System.out.println("Before sort =" + productsList);
        List<Product> sorted = productsList.stream()
                .sorted(Comparator.comparingDouble(p -> p.price))
                .collect(Collectors.toList());
        System.out.println("After sort =" + sorted);

    }
}
