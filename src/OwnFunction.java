import java.util.function.Function;

public class OwnFunction {

    public interface F1<T, R> extends Function<T, R> {
        int calculate(int x);
    }

    public static void main(String[] args) {

    }
}
