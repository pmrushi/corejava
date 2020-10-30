import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MethodReferenceTest {

    static Predicate<String> predicate = new Predicate<String>() {
        @Override
        public boolean test(String s) {
            return s.startsWith("c");
        }
    };
    public static void main(String[] args) {
        List<String> names = List.<String>of("abc", "cde", "def");
        //names.forEach(s -> String.format("test %s", s));
        //names.forEach(s -> String.valueOf(s));
        List<String> collect = names.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect);
    }
}
