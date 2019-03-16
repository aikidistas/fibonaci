package org.aikidistas.fibonaci;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class CalculatorImplTest {

    private CalculatorImpl calculator;

    @Before
    public void setUp() {
        calculator = new CalculatorImpl();
    }

    @Test
    public void fibonaci_zero() {
        assertEquals(BigInteger.valueOf(1), calculator.fibonaci(0));
    }

    @Test
    public void fibonaci_one() {
        assertEquals(BigInteger.valueOf(1), calculator.fibonaci(1));
    }

    @Test
    public void fibonaci_two() {
        assertEquals(BigInteger.valueOf(2), calculator.fibonaci(2));
    }

    @Test
    public void fibonaci_returns_longNumber() {
        assertEquals(new BigInteger("573147844013817084101"), calculator.fibonaci(100));
        assertEquals(
                new BigInteger(FileUtil.read("/fibonaci_1_000.txt")),
                calculator.fibonaci(1_000)
        );
    }

    @Test
    public void fibonaci_withoutStackOwerflow() {
        assertEquals(
                new BigInteger(FileUtil.read("/fibonaci_10_000.txt")),
                calculator.fibonaci(10_000)
        );
    }

    @Test
    public void fibonaci_HundredThousand() {
        assertEquals(
                new BigInteger(FileUtil.read("/fibonaci_100_000.txt")),
                calculator.fibonaci(100_000)
        );
    }

    @Test
    @Ignore("This is slow/long test. Just run it manually when really needed")
    public void fibonaci_Million() {
        assertEquals(
                new BigInteger(FileUtil.read("/fibonaci_1_000_000.txt")),
                calculator.fibonaci(1_000_000)
        );
    }
}