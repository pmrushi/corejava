import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class StreamReduce {

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

        // reduce - combine elements of a stream and produces a single value
        Double valSum = productsList.stream()
                .mapToDouble(value -> value.price)
                .reduce(0, (p1, p2) -> p1 + p2);
        System.out.println("sum =" + valSum);

        Optional<Double> minVal = productsList.stream()
                .map(product -> product.price)
                .reduce((p1, p2) -> p1 < p2 ? p1 : p2);
        System.out.println("min =" + minVal.get());

        Optional<Double> maxVal = productsList.stream()
                .map(product -> product.price)
                .reduce((p1, p2) -> p1 > p2 ? p1 : p2);
        System.out.println("max =" + maxVal.get());

        Double sum = productsList.stream()
                .mapToDouble(value -> value.price)
                .sum();
        System.out.println("sum ==" + sum);

        OptionalDouble min1 = productsList.stream()
                .mapToDouble(value -> value.price)
                .min();
        System.out.println("min1 ==" + min1.getAsDouble());

        OptionalDouble max1 = productsList.stream()
                .mapToDouble(value -> value.price)
                .max();
        System.out.println("max1 ==" + max1.getAsDouble());

        Product min = productsList.stream()
                .min(Comparator.comparing(product -> product.price))
                .orElse(null);
        System.out.println("min ==" + min.price);

        Product max = productsList.stream()
                .max(Comparator.comparing(product -> product.price))
                .orElse(null);
        System.out.println("max ==" + max.price);

        List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
        Optional<Integer> maxNumber = list.stream()
                .max((i, j) -> i.compareTo(j));
        System.out.println("max 2 = " + maxNumber.get());
    }
}
