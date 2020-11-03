import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class MethodReferenceConstructor {

    public static void main(String[] args) {
        // lambda expression
        BiFunction<String, String, Locale> f = new BiFunction<String, String, Locale>() {
            @Override
            public Locale apply(String lang, String code) {
                return new Locale(lang, code);
            }
        };
        System.out.println(f.apply("", "US").getDisplayCountry());

        BiFunction<String, String, Locale> f2 = (lang, code) -> new Locale(lang, code);

        // method reference
        BiFunction<String, String, Locale> f1 = Locale::new;
        System.out.println(f1.apply("", "US").getDisplayCountry());

        List<String> names = List.of("abc", "cde", "def");
        List<String> list = names.stream()
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
        System.out.println(list);

        List<String> list1 = names.stream()
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(list1);

    }
}
