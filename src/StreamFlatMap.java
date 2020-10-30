import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMap {
    public static void main(String[] args) {

        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg")
        );
        System.out.println(namesNested);
        List<String> namesFlatStream = namesNested.stream()
                .flatMap(strings -> strings.stream())
                .collect(Collectors.toList());
        System.out.println(namesFlatStream);

        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11, 13);
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);
        List<List<Integer>> listOfListOfInts = Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);
        System.out.println("The Structure before flattening is : " + listOfListOfInts);
        List<Integer> listOfInts = listOfListOfInts.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println("The Structure after flattening is : " + listOfInts);
    }
}
