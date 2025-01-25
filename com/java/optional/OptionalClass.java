package com.java.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {

        String str= null;

        Optional<String> optional = Optional.ofNullable(str);
        System.out.println(optional.isPresent());
        System.out.println(optional.isEmpty());

        String s = optional.orElse("mine is nothing instead of God !!");
        System.out.println(s);

        List<Integer>list= Arrays.asList(1,23,12,45,15,67);
        Optional<List<Integer>> integerList = Optional.ofNullable(list);
        List<Integer> list1 = integerList.orElseThrow();
        System.out.println(list1);
        System.out.println(integerList.isEmpty());
        System.out.println(integerList.equals(list));

        // equals method

        Optional<String> s1 = Optional.ofNullable("Hello");
        Optional<String> s2 = Optional.ofNullable("World");
        Optional<String> s3 = Optional.ofNullable("Hello");

        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s1));

        Optional<String> ram = Optional.of("Ram");
        Optional<String> krishna = Optional.of("Ram");
        Optional<String> radha = Optional.of("Ram");
        System.out.println(ram.equals(krishna));


    }
}
