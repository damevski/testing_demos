import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TemplateTest {

    @Test
    public void singleVariableTest() {
        Template template = new Template("Hello, ${name}");
        template.set("name","Reader");
        assertEquals("Hello, Reader", template.evaluate());
    }

    @Test
    public void anotherSingleVariableTest() {
        Template template = new Template("Hello, ${name}");
        template.set("name","something else");
        assertEquals("Hello, something else", template.evaluate());
    }

    @Test
    public void multipleVariableTest() {
        Template template = new Template("${one}, ${two}, ${three}");
        template.set("one","1");
        template.set("two","2");
        template.set("three","3");
        assertEquals("1, 2, 3", template.evaluate());
    }


    @Test
    public void unknownVariablesAreIgnored() {
        Template template = new Template("Hello, ${name}");
        template.set("name", "something else");
        template.set("unknown", "nothing");
        assertEquals("Hello, something else", template.evaluate());
    }

    @Test
    public void missingVariableThrowsException() {
        Template template = new Template("Hello, ${name}");
        assertThrows(MissingValueException.class, () -> {
            template.evaluate();
        });
    }
}

