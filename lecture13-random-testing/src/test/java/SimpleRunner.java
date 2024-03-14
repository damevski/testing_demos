import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SimpleRunner {

    // 1: simple random text generator
    @Test
    public void fuzzingSampleTest() {
        RandomFuzzer fuzzer = new RandomFuzzer(5,10);
        fuzzer.runs( (fuzzStr) -> {
            System.out.println(fuzzStr);
            return Fuzzer.Outcome.PASS;
        },100);
    }

    // 2: call the URL decoder
    @Test
    public void noFuzzDecoderTest() {
        try {
            String s = URLDecoder.cgi_decode("http://www.google.com/a+b%20c/");
            assertEquals("http://www.google.com/a b c/", s);
        }
        catch (Exception e) {
            fail();
        }
    }

    // 3: put 1 and 2 together
    @Test
    public void fuzzingDecoderTest() {
        RandomFuzzer fuzzer = new RandomFuzzer(5,50);
        Fuzzer.Outcome[] outcomes = fuzzer.runs( (fuzzStr) -> {
                try {
                    System.out.println(fuzzStr);
                    String s = URLDecoder.cgi_decode(fuzzStr);
                    return Fuzzer.Outcome.PASS;
                }
                catch (ParseException e) {
                    return Fuzzer.Outcome.PASS;
                }
                catch (Exception e) {
                    return Fuzzer.Outcome.FAIL;
                }
            },50000);
        assert(Arrays.stream(outcomes)
                .filter(x -> x.equals(Fuzzer.Outcome.FAIL))
                .count() == 0);
    }


}
