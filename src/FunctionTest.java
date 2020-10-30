import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionTest {
    static Function<String, Long> function = new Function<String, Long>() {
        @Override
        public Long apply(String s) {
            return Long.valueOf(s);
        }
    };

    public static void main(String[] args) {
        List<String> numbers = List.of("1", "2", "3");
        String s1 = "test";
        Function<String, Long> f1 = s -> {
            return Long.valueOf(s1);
        };
        for (String s: numbers) {
            Long l = f1.apply(s);
            System.out.println(l);
        };

        BiFunction<String, String, Long> bf = new BiFunction<String, String, Long>() {
            @Override
            public Long apply(String s, String s2) {
                return null;
            }
        };

        Supplier<String> s = new Supplier<String>() {
            @Override
            public String get() {
                return "null";
            }
        };

        List<Long> list = numbers.stream().map(function).collect(Collectors.toList());
        System.out.println(list);
    }
}