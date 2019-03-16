package org.aikidistas.fibonaci;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class CachedCalculatorImpl implements Calculator {

    Calculator calculator;
    Map<Long, BigInteger> calculatedFibonaci = new HashMap<>();

    public CachedCalculatorImpl(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public BigInteger fibonaci(long n) {
        BigInteger value = getCachedFibonaci(n);
        if (value != null) {
            return value;
        }
        value = calculator.fibonaci(n);
        setCachedFibonaci(n, value);

        return value;
    }

    private BigInteger getCachedFibonaci(Long n) {
        return calculatedFibonaci.get(n);
    }

    private void setCachedFibonaci(Long n, BigInteger value) {
        calculatedFibonaci.put(n, value);
    }
}
