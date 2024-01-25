import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TemplateTest {

//    @Test
//    public void oneVariable() {
//        Template template = new Template("Hello, ${name}");
//        template.set("name","Reader");
//        assertEquals("Hello, Reader", template.evaluate());
//    }
//
//    @Test
//    public void anotherVariable() {
//        Template template = new Template("Hello, ${name}");
//        template.set("name","something else");
//        assertEquals("Hello, something else", template.evaluate());
//    }

    @ParameterizedTest
    @ValueSource(strings = {"Reader", "something else", "", "blah blah"})
    public void paramVariable(String var) {
        Template template = new Template("Hello, ${name}");
        template.set("name",var);
        assertEquals("Hello, " + var, template.evaluate());
    }

//    @Test
//    public void multipleVariables() {
//        Template template = new Template("${one}, ${two}, ${three}");
//        template.set("one","1");
//        template.set("two","2");
//        template.set("three","3");
//        assertEquals("1, 2, 3", template.evaluate());
//    }

    @ParameterizedTest
    @MethodSource("provideThreeVars")
    public void paramMultipleVariables(String v1, String v2, String v3) {
        Template template = new Template("${one}, ${two}, ${three}");
        template.set("one",v1);
        template.set("two",v2);
        template.set("three",v3);
        assertEquals(v1 + ", " + v2 +", " + v3, template.evaluate());
    }

    private static Stream<Arguments> provideThreeVars() {
        return Stream.of(
                Arguments.of("1","2","3"),
                Arguments.of("larry","curly","moe"),
                Arguments.of("athos","porthos","aramis")
        );
    }

    @Test
    public void unknownVariablesAreIgnored() {
        Template template = new Template("Hello, ${name}");
        template.set("name","Reader");
        template.set("unknown","ignoreme");
        assertEquals("Hello, Reader", template.evaluate());
    }

    @Test
    public void missingValueThrowsException() {
        Template template = new Template("Hello, ${name}");
        assertThrows(MissingValueException.class, () -> {
                template.evaluate();
            });
    }
}
