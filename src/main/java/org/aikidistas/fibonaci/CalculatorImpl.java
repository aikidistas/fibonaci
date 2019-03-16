package org.aikidistas.fibonaci;

import java.math.BigInteger;

public class CalculatorImpl implements Calculator {

    @Override
    public BigInteger fibonaci(long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n < 2) {
            return BigInteger.ONE;
        }

        BigInteger value = BigInteger.ZERO;
        BigInteger lastValue = BigInteger.ONE;
        BigInteger secondLastValue = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            value = lastValue.add(secondLastValue);
            secondLastValue = lastValue;
            lastValue = value;
        }

        return value;
    }
}
