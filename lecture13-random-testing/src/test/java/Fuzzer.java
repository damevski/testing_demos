import java.util.function.Function;

/*
 * based on code published on fuzzingbook.org
 */
public abstract class Fuzzer {

    public enum Outcome {
        PASS,
        FAIL,
        UNRESOLVED
    }

    Fuzzer() { }

    public abstract String fuzz();

    public Outcome run(Function<String,Outcome> runner) {
        return runner.apply(fuzz());
    }

    public Outcome[] runs(Function<String,Outcome> runner, int trials) {
        Outcome[] outcomes = new Outcome[trials];
        for(int i=0;i<trials;i++) {
            outcomes[i] = runner.apply(fuzz());
        }
        return outcomes;
    }
}
