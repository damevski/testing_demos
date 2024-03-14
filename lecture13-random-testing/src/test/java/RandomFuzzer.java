import java.util.Random;

public class RandomFuzzer extends Fuzzer {

    private int max_length;
    private int min_length;
    private char char_start;
    private int char_range;

    private RandomFuzzer() {}

    RandomFuzzer(int min_length, int max_length, char char_start, int char_range) {
        this.min_length = min_length;
        this.max_length = max_length;
        this.char_start = char_start;
        this.char_range = char_range;
    }

    public RandomFuzzer(int min_length, int max_length) {
        this(min_length, max_length, 'a', 32);
    }

    @Override
    public String fuzz() {
        StringBuilder outSB = new StringBuilder();
        Random rnd = new Random();
        int stringLength = rnd.nextInt(max_length - min_length) + min_length;
        for(int i=0;i<stringLength;i++) {
            outSB.append((char) (char_start + rnd.nextInt(char_range)));
        }
        return outSB.toString();
    }

}
