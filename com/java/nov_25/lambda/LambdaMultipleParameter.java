package com.java.nov_25.lambda;

interface Sum{
    int sum(int a,int b,int c);
}

public class LambdaMultipleParameter
{
    public static void main(String[] args) {

        Sum s=(a,b,c)->{
            return a+b+c;
        };
        System.out.println(s.sum(3,4,5));
    }
}
