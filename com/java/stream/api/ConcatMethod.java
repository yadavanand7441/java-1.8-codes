package com.java.stream.api;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatMethod {
    public static void main(String[] args) {

        List<Integer> numbers1 = Arrays.asList(12, 45, 15, 6, 35, 37, 89, 56);
        List<Integer> numbers2 = Arrays.asList(8, 16, 24, 6, 15, 53, 85, 41);

        Stream<Integer> stream1 = numbers1.stream();
        Stream<Integer> stream2 = numbers2.stream();

        Stream<Integer> concatStream = Stream.concat(stream1, stream2);
        concatStream.forEach(System.out::println);

        System.out.println("===============");
        concatStream = Stream.concat(numbers1.stream(), numbers2.stream());
        long count = concatStream.count();
        System.out.println(count);



        // concat two string
        System.out.println("===============");
        List<String> string1 = Arrays.asList("Ram", "Shyam", "Radha", "Sita");
        List<String> string2 = Arrays.asList("Mohan", "Krishna", "Radhika", "Ramya");

        Stream<String> concatString1 = string1.stream();
        Stream<String> concatString2 = string2.stream();
        Stream<String> concatString = Stream.concat(concatString1, concatString2);//.forEach(System.out::println);
        long count2 = concatString.count();
        System.out.println(count2);

        //stream to integer convert
        System.out.println("===============");
        Stream<Integer> numberStream = numbers1.stream();
        Stream<String> stringStream = string1.stream();
        long count3 = Stream.concat(numberStream.map(Objects::toString), stringStream).count();
        System.out.println(count3);


        System.out.println("===============");
        List<String> str1 = Arrays.asList("a", "b", "c");
        List<Integer> str2 = Arrays.asList(1,2,3);

        Stream<String> stringStream1 = str1.stream();
        Stream<Integer> stringStream2 = str2.stream();
        Stream.concat(stringStream1.map(Objects::toString),stringStream2).forEach(System.out::println);
        Stream<?> concat = Stream.concat(str1.stream(), str2.stream());
        long count1 = concat.count();
        System.out.println(count1);


    }
}
