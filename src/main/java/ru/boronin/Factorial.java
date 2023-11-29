package ru.boronin;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.LongStream;
public class Factorial {
    public BigInteger calculateRec (long n){
        return ((BigInteger.valueOf(n).compareTo(BigInteger.ZERO) ==0) ||
                BigInteger.valueOf(n).compareTo(BigInteger.ONE)==0)
                ? BigInteger.ONE : calculateRec(n-1).multiply(BigInteger.valueOf(n));
    }

    public BigInteger calculateStream (long n){
        ArrayList <BigInteger> bigIntegers = new ArrayList<>();
        LongStream.rangeClosed(1,n).forEach((x)->bigIntegers.add(BigInteger.valueOf(x)));
        return bigIntegers.stream().reduce(BigInteger.ONE, BigInteger::multiply);

    }
    public BigInteger calculateLoop (long n){
        if ((n==0) || n==1) {return BigInteger.ONE;}
        BigInteger res = BigInteger.ONE;
        for (int i =1; i <=n ; i++){
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
}
