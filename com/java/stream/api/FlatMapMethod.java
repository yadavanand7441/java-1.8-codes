package com.java.stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class FlatMapMethod {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(12, 45,12,2, 56, 24, 35, 67, 2);
        System.out.println("===================");
        int sum1 = integerList.stream().flatMapToInt(s -> IntStream.of(s)).sum();
        System.out.println(sum1);
        System.out.println("===================");
        int sum2 = integerList.stream().limit(3).flatMapToInt(s -> IntStream.of(s)).sum();
        System.out.println("Sum2: "+sum2);

        System.out.println("===================");
        int sum3 = integerList.stream().filter(e->e%2==0).limit(4).flatMapToInt(s -> IntStream.of(s)).sum();
        System.out.println("sum3:"+sum3);

        System.out.println("===================");
        integerList.stream().flatMap(e->Arrays.asList(e).stream()).collect(Collectors.toList()).stream().
                distinct().sorted().forEach(System.out::println);
        System.out.println("===================");
        List<String> listString = Arrays.asList("Anand", "Mohan", "Gopal","Sohan");
        listString.stream().flatMap(e->Arrays.asList(e).stream()).collect(Collectors.toList()).stream().
                distinct().sorted().forEach(System.out::println);
        System.out.println("===================");
        List<Double> doublesList = Arrays.asList(234.2, 121.4, 654.3, 123.3, 563.9);
        doublesList.stream().flatMap(e->Arrays.asList(e).stream()).collect(Collectors.toList()).stream().
                distinct().sorted().forEach(System.out::println);

        System.out.println("===================");
        double sum = doublesList.stream().flatMapToDouble(d -> DoubleStream.of(d)).sum();
        System.out.println(sum);


    }
}
