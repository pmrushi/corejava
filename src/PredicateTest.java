import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {

    static Predicate<String> predicate = new Predicate<String>() {
        @Override
        public boolean test(String s) {
            return s.startsWith("c");
        }
    };
    public static void main(String[] args) {
        List<String> names = List.<String>of("abc", "cde", "def");
        names.forEach(s -> String.format("test %s", s));
        names.forEach(String::format);

        for(String s : names) {
            if (predicate.test(s)) {
                System.out.println(s);
            }
        }

        Predicate<String> pr1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("A");
            }
        };

        Predicate<String> p1 = s -> s.startsWith("a");
        //Predicate<String> p2 = (s) -> !s.startsWith("a");

        BiPredicate<String, Long> bi = new BiPredicate<String, Long>() {
            @Override
            public boolean test(String s, Long aLong) {
                return false;
            }
        };

        System.out.println(p1.negate().test("Abc"));


        Predicate<String> pr = (s) -> s.startsWith("a");
        List<String> list = names.stream().filter(pr).collect(Collectors.toList());

        // List<String> list = names.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
        //System.out.println(list);
    }

}
