import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.boronin.Factorial;

import java.math.BigInteger;

public class FactorialTest {
    public static Factorial factorial;
    @BeforeAll
    public static void setup (){
        factorial = new Factorial();
    }
    @Test
    public void factorialLoopTest (){
    BigInteger actual = factorial.calculateLoop(50);
        BigInteger expected = new BigInteger("30414093201713378043612608166064768844377641568960512000000000000");
        Assertions.assertEquals(actual,expected);
    }
    @Test
    public void factorialStreamTest (){
        BigInteger actual = factorial.calculateStream(50);
        BigInteger expected = new BigInteger("30414093201713378043612608166064768844377641568960512000000000000");
        Assertions.assertEquals(actual,expected);
    }
    @Test
    public void factorialRecursion (){
        BigInteger actual = factorial.calculateRec(50);
        BigInteger expected = new BigInteger("30414093201713378043612608166064768844377641568960512000000000000");
        Assertions.assertEquals(actual,expected);
    }
    @Test
    public void factorialLoopTestOfNull (){
        BigInteger actual = factorial.calculateLoop(0);
        BigInteger expected = BigInteger.ONE;
        Assertions.assertEquals(actual,expected);
    }
    @Test
    public void factorialStreamTestOfNull (){
        BigInteger actual = factorial.calculateStream(0);
        BigInteger expected = BigInteger.ONE;
        Assertions.assertEquals(actual,expected);
    }
    @Test
    public void factorialRecursionTestOfNull (){
        BigInteger actual = factorial.calculateRec(0);
        BigInteger expected = BigInteger.ONE;
        Assertions.assertEquals(actual,expected);
    }
}
