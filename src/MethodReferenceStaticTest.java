import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodReferenceStaticTest {

    public static void main(String[] args) {
        List<String> numbers = new ArrayList<String>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");

        // anonymous class
        numbers.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // lambda expression
        numbers.forEach(s -> System.out.println(s));

        // method reference
        numbers.forEach(System.out::println);

        // anonymous class
        List<Integer> integers = numbers.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        }).collect(Collectors.toList());
        System.out.println("anonymous :" + integers);

        // lambda expression
        List<Integer> integers1 = numbers.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        System.out.println("lambda :" + integers1);

        // method reference
        List<Integer> integers2 = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("method reference :" + integers2);

        // anonymous class
        List<Integer> collect = integers.stream()
                .filter(s -> s % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("anonymous1 :" + collect);
        // lambda expression
        List<Integer> collect1 = integers.stream()
                .filter(s -> s % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("lambda1 :" + collect1);
        // method reference
        List<Integer> collect2 = integers.stream()
                .filter(MethodReferenceStaticTest::isEven)
                .collect(Collectors.toList());
        System.out.println("method reference1 :" + collect2);
    }

    private static boolean isEven(Integer s) {
        return s % 2 == 0;
    }
}
