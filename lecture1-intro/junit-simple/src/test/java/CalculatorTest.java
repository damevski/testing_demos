import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void setupCalculatorTesting() {
        calculator = new Calculator();
    }

    @Test
    public void testDivide() {
        int result = calculator.divide(2, 2);
        assertEquals(1, result);
    }

    @Test
    public void testTruncate() {
        int result = calculator.divide(3, 2);
        assertEquals(1, result);
    }

    @Test
    public void testDivideByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            int result = calculator.divide(2, 0);
        });
    }



}