import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

public class Mutators {

    public static Function<String,String> deleteRandomCharacter = (s) -> {
        if (s == "") {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        Random random = new Random();
        int pos = random.nextInt(s.length());
        System.out.println("Deleting " + s.charAt(pos) + " at " + pos);
        return sb.deleteCharAt(pos).toString();
    };

    public static Function <String,String> insertRandomCharacter = (s) -> {
        StringBuilder sb = new StringBuilder(s);
        Random random = new Random();
        int pos = random.nextInt(s.length());
        char randChar = (char) (random.nextInt(127-32) + 32);
        System.out.println("Inserting " + randChar + " at " + pos);
        return sb.insert(pos,randChar).toString();
    };

    public static Function<String,String> flipRandomCharacter = (s) -> {
        if (s == "") {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        Random random = new Random();
        int pos = random.nextInt(s.length());
        int bit = 1 << random.nextInt(6);
        sb.setCharAt(pos, (char) (s.charAt(pos) ^ bit));
        System.out.println("Flipping " + s.charAt(pos) + " to " + sb.substring(pos,pos+1));
        return sb.toString();
    };
}
