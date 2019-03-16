package org.aikidistas.fibonaci;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CachedCalculatorImplTest {
    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new CachedCalculatorImpl(new CalculatorImpl());
    }

    @Test
    public void fibonaci_hundredThousand() {
        assertEquals(
                new BigInteger(FileUtil.read("/fibonaci_100_000.txt")),
                calculator.fibonaci(100_000)
        );
    }

    @Test
    public void fibonaci_calculateSameSecondTime_inMillisecond() {
        calculator.fibonaci(100_000);

        long timeBeforeSecondRun = System.currentTimeMillis();
        calculator.fibonaci(100_000);
        long timeAfterSecondRun = System.currentTimeMillis();

        long delta = timeAfterSecondRun - timeBeforeSecondRun;

        assertTrue(delta <= 1);
    }
}