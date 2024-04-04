import java.util.HashSet;

public class Hello {
    public static void main(String args[]) {


        HashSet<String> testList = new HashSet<>();
        System.out.println("*********BREAK************");
        testList.add("9000");
        System.out.println("*********BREAK************");
        HashSet<String> testList2 = new HashSet<>(testList);
        System.out.println("*********BREAK************");
        testList.remove("9000");
    }
}
