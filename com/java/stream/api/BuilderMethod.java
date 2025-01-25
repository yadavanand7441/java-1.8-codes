package com.java.stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BuilderMethod {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(12, 45, 15, 6, 35, 37, 89, 56);
        Stream<Integer> stream = Stream.<Integer>builder().add(14).
                add(24)
                .add(56).
                build();
        stream.forEach(System.out::println);
    }
}
