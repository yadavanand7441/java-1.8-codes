package com.java.nov_25.method_ref;

import java.util.function.BiFunction;

public class MathsExample
{
    public static int add(int a,int b)
    {
        return a+b;
    }
    public static int sub(int a,int b)
    {
        return a-b;
    }
    public static int mul(int a,int b)
    {
        return a*b;
    }
    public static float Div(float a,float b)
    {
        return a/b;
    }

    public static void main(String[] args) {

        BiFunction<Integer,Integer,Integer>result=MathsExample::add;
        Integer sum = result.apply(2, 3);
        System.out.println("Sum: "+sum);

        BiFunction<Integer,Integer,Integer>result2=MathsExample::sub;
        Integer sub = result2.apply(4, 1);
        System.out.println("Sub: "+sub);

        BiFunction<Integer,Integer,Integer>result3=MathsExample::mul;
        Integer mul = result3.apply(4, 1);
        System.out.println("mul: "+mul);

        BiFunction<Float,Float,Float>result4=MathsExample::Div;
        Float Div = result4.apply(4.56f, 3f);
        System.out.println("Div: "+Div);

    }
}
