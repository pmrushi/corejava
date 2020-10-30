import javax.swing.*;
import java.util.*;
import java.util.function.Consumer;

public class ForEach {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        StringJoiner s = new StringJoiner(",");
        List<String> fruits = List.of("apple", "bottle");
        for(int i=0;i<fruits.size();i++) {
            String val = fruits.get(i);
            System.out.println(val);
        }
        for(String val : fruits) {
            System.out.println(val);
        }

        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        fruits.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("-----" + s);
            }
        });
        fruits.iterator().forEachRemaining(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("-----" + s);
            }
        });

        ListIterator<String> listIterator = fruits.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
            System.out.println(listIterator.nextIndex());
        }
    }
}
