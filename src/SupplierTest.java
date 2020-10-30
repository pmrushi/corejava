import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("node", "java", "python", "ruby");
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                printNames(new Supplier<String>() {
                    @Override
                    public String get() {
                        return s;
                    }
                });
            }
        });
    }
    private static void printNames(Supplier<String> supplier) {
        System.out.println(supplier.get());
    }
}
