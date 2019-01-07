package com.task;

import java.math.BigInteger;

public class ReversedFactorial {

    // Value from which reversed factorial needs to be calculated
    private BigInteger factorial;

    // Calculated value
    private int result;

    // Setter for factorial
    public void setFactorial(BigInteger factorial)
    {
        if(factorial.compareTo(BigInteger.ONE) < 1)  throw new Error("Factorial can not be lower than 1.");
        this.factorial = factorial;
    }

    // Getter for factorial
    public BigInteger getFactorial()
    {
        return this.factorial;
    }

    // Getter for reversedFactorial
    public int getResult()
    {
        this.setResult();
        return this.result;
    }

    // Setter  for reversedFactorial
    private void setResult()
    {
        BigInteger del = this.factorial;
        int i = 1;
        while (del.compareTo(BigInteger.ONE) == 1){
            i++;
            del = del.divide(BigInteger.valueOf(i));
        }
        this.result = i >= 1 ? i : 0;
    }
}