package org.kazeneko;

import java.math.BigInteger;

public enum MathOperations {
    MULT,
    EXP,
    FACT,
    FIB;
    public static long multiplication(int number, int coefficient) {
        return (long) number * coefficient;
    }
    public static BigInteger exponentiation(int number, int coefficient) {
        return BigInteger.valueOf(number).pow(coefficient);
    }
    public static BigInteger factorialisation(int number) {
        BigInteger factorial = BigInteger.valueOf(1);
        for (int i = 1; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
    public static BigInteger getFibonacciNumber(int number) {
        if (BigInteger.valueOf(number).compareTo(BigInteger.valueOf(0)) == 0) {
            return BigInteger.valueOf(0);
        }
        BigInteger n0 = BigInteger.valueOf(0);
        BigInteger n1 = BigInteger.valueOf(1);
        for (var i = BigInteger.valueOf(2); i.compareTo(BigInteger.valueOf(number)) <= 0; i = i.add(BigInteger.ONE)) {
            var n2 = n0.add(n1);
            n0 = n1;
            n1 = n2;
        }
        return n1;
    }
}
