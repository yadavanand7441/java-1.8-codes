package com.java.nov_25.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaExample1 {
    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);

        // using forEach loop
        System.out.println("using forEach");
        integerList.forEach(number->System.out.print(number+" "));
        System.out.println();

        //using map and reduce
        int intSumOfSquare= integerList.stream().map(x->x*x).reduce(0,Integer::sum);
        System.out.println("SumOfSquare:"+ intSumOfSquare);
        System.out.println();

        //using filter
        List<Integer> list = integerList.stream().filter(i -> i % 2 == 0).toList();
        System.out.println("Even: "+list);

    }
}
