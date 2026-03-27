package com.java.march_26.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {

        String str=null;
        Optional<String>str1= Optional.ofNullable(str);
        System.out.println(str1.isPresent());
        System.out.println(str1.isEmpty());

        //throwing user messages
        String orElse = str1.orElse("mine is nothing instead of GOD");
        System.out.println(orElse);

        List<Integer> list= Arrays.asList(1,23,12,45,15,67);
        Optional<List<Integer>> integerList = Optional.of(list);
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

        System.out.println("GOD");
        Optional<String> string1= Optional.ofNullable("Ram");
        Optional<String>string2=Optional.ofNullable("Krishna");
        System.out.println(string1.equals(string2));

    }
}
