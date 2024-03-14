import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class MutationFuzzer extends Fuzzer {

    private MutationFuzzer() {}

    private String[] seeds;
    private ArrayList<Function<String,String>> mutators;

    MutationFuzzer(String[] seeds, ArrayList<Function<String,String>> mutators) {
        this.seeds = seeds;
        this.mutators = mutators;
    }

    @Override
    public String fuzz() {
        Random rnd = new Random();
        int s = rnd.nextInt(seeds.length);
        String seed = seeds[s];
        int m = rnd.nextInt(mutators.size());
        return mutators.get(m).apply(seed);
    }
}
