import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.boronin.Calculator;

public class CalculatorTest {
    @Test
    void testCalcSum() {
        Calculator calculator = new Calculator();
        double a = 1;
        double b = 2;
        double actual = calculator.sum(a, b);  //a+b
        double expected = 3.0d;
        Assertions.assertEquals(actual, expected);
    }
    @Test
    void testCalcSub() {
        Calculator calculator = new Calculator();
        double a = 1;
        double b = 2;
        double actual = calculator.sub(a, b);  //a-b
        double expected = -1.0d;
        Assertions.assertEquals(actual, expected);
    }
    @Test
    void testCalcMult() {
        Calculator calculator = new Calculator();
        double a = 1;
        double b = 2;
        double actual = calculator.mult(a, b);  //a*b
        double expected = 2.0d;
        Assertions.assertEquals(actual, expected);
    }
    @Test
    void testCalcDiv() {
        Calculator calculator = new Calculator();
        double a = 1;
        double b = 2;
        double actual = calculator.div(a, b);  //a/b
        double expected = 0.5d;
        Assertions.assertEquals(actual, expected);
    }
    @Test
    void testCalcDivByZero() {
        Calculator calculator = new Calculator();
        double a = 1;
        try {
            calculator.div(a, 0);  //a/0
            Assertions.fail("Арифметическая ошибка не выброшена");
        } catch (ArithmeticException e) {
            Assertions.assertEquals("Division by zero", e.getMessage());
        }
    }
}
