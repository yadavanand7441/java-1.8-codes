package com.java.stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class DistinctMethod {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 45, 15, 6, 6, 37, 89, 56,12,47);
        //numbers.stream().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("=======================");
        numbers.stream().distinct().forEach(System.out::println);
        System.out.println("=======================");
        numbers.stream().flatMap(e->Arrays.asList(e).stream()).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("=======================");
        numbers.stream().sorted().forEach(System.out::println);


        System.out.println("=========FlatMapToDouble============");

        List<List<Double>> doubles = Arrays.asList(Arrays.asList(12.5, 45.6, 15.7, 6.2),
                Arrays.asList(4.5, 5.6),
                Arrays.asList(6.7, 7.8, 8.9));

        doubles.stream().flatMap(e->e.stream()).mapToDouble(Double::doubleValue).forEach(System.out::println);


    }
}
