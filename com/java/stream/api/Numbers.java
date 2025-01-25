package com.java.stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Numbers {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(12, 45, 15, 6, 35, 37, 89, 56);
        System.out.println("Even number: ");
        numbers.stream().filter(e->e%2==0).forEach(System.out::println);
        numbers.stream().max(Integer::compareTo).ifPresent(System.out::println);
        numbers.stream().min(Integer::compare).ifPresent(System.out::println);
        numbers.stream().findFirst().ifPresent(System.out::println);
        numbers.stream().findAny().ifPresent(System.out::println);

    }
}
