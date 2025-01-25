package com.java.stream.api;

import java.util.Arrays;
import java.util.List;

public class AllMatchMethod {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(12, 45, 15, 6, 35, 37, 89, 56);
        boolean allMatch = list.stream().allMatch(e -> e > 34);
        System.out.println(allMatch);

        System.out.println(list.stream().anyMatch(e->e%2==0));


    }
}
