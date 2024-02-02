import java.util.ArrayList;
import java.util.Iterator;

public class IterExample {

    private static void printIterator(Iterator<String> iter) {
        while (iter.hasNext()) {
            String element = iter.next();
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pie");
        Iterator<String> iter = list.iterator();
        printIterator(iter);
        Iterator<String> iter2 = list.iterator();
        iter2.next();
        iter2.remove();
        printIterator(iter2);
    }

}
