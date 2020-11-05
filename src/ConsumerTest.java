import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("node", "java", "python", "ruby");
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        list.forEach(s -> System.out.println(s));

        // list.stream().forEach(s -> System.out.println(s));
    }
}
