import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
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

        BiFunction<Long, String, Integer> biFunction = MethodReferenceClassInstance::apply;


        // lambda expression
        List<String> sorted = strings.stream()
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return s1.compareTo(s2);
                    }
                })
                .collect(Collectors.toList());
        System.out.println(sorted);

        // method reference
        List<String> sortedAlt = strings
                .stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        // revere order
        Comparator<String> compareTo = String::compareTo;
        List<String> reverseSorted = strings.stream()
                .sorted(compareTo.reversed())
                .collect(Collectors.toList());
        System.out.println(reverseSorted);

        List<String> revSort = strings.stream()
                .sorted(((Comparator<String>) String::compareTo).reversed())
                .collect(Collectors.toList());
        System.out.println("rev sort : " + revSort);

        List<String> comparatorComparing = strings.stream()
                .sorted(Comparator.comparing(s -> s))
                .collect(Collectors.toList());
        System.out.println("comparatorComparing : " + comparatorComparing);

    }

    private static Integer apply(Long aLong, String s) {
        return s.compareTo(String.valueOf(aLong));
    }
}
