import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceClassInstance {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,12,433,5);

        // lambda expression
        Integer max = integers.stream().reduce((a, b) -> Math.max(a, b)).get();
        System.out.println("Max : " + max);

        // method reference
        Integer max1 = integers.stream().reduce( Math::max ).get();
        System.out.println("Max1 : " + max1);

        List<String> strings = Arrays.asList("how", "to", "do", "in", "java", "dot", "com");

        // lambda expression
        List<String> sorted = strings.stream()
                .sorted((s1, s2) -> s1.compareTo(s2))
                .collect(Collectors.toList());
        System.out.println(sorted);

        // method reference
        List<String> sortedAlt = strings
                .stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        System.out.println(sortedAlt);

    }
}
