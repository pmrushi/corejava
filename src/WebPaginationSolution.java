import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'fetchItemsToDisplay' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_STRING_ARRAY items
     *  2. INTEGER sortParameter
     *  3. INTEGER sortOrder
     *  4. INTEGER itemsPerPage
     *  5. INTEGER pageNumber
     */

    public static List<String> fetchItemsToDisplay(List<List<String>> items,
                                                   int sortParameter, int sortOrder,
                                                   int itemsPerPage, int pageNumber) {
        // System.out.println(sortParameter + " -- " + sortOrder + " -- " + itemsPerPage + " -- " + pageNumber);
        int start = pageNumber == 0 ? 0 : (pageNumber * itemsPerPage);
        return items.stream()
                .sorted((l1, l2) -> {
                    if (sortOrder == 0) {
                        if (sortParameter == 0) {
                            return l1.get(sortParameter).compareTo(l2.get(sortParameter));
                        } else {
                            return Integer.valueOf(l1.get(sortParameter)).compareTo(Integer.valueOf(l2.get(sortParameter)));
                        }
                    } else {
                        if (sortParameter == 0) {
                            return l2.get(sortParameter).compareTo(l1.get(sortParameter));
                        } else {
                            return Integer.valueOf(l2.get(sortParameter)).compareTo(Integer.valueOf(l1.get(sortParameter)));
                        }
                    }
                })
                .map(s -> s.get(0))
                .skip(start)
                .limit(itemsPerPage)
                .collect(Collectors.toList());
    }
}

public class WebPaginationSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int itemsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int itemsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> items = new ArrayList<>();

        IntStream.range(0, itemsRows).forEach(i -> {
            try {
                items.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int sortParameter = Integer.parseInt(bufferedReader.readLine().trim());

        int sortOrder = Integer.parseInt(bufferedReader.readLine().trim());

        int itemsPerPage = Integer.parseInt(bufferedReader.readLine().trim());

        int pageNumber = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = Result.fetchItemsToDisplay(items, sortParameter, sortOrder, itemsPerPage, pageNumber);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
