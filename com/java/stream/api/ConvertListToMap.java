package com.java.stream.api;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ConvertListToMap {
    public static void main(String[] args) {

        List<String>stringList=new ArrayList<>();
        stringList.add("Anand");
        stringList.add("Mohan");
        stringList.add("Radha");
        stringList.add("Sohan");

        Map<String, Integer> stringIntegerMap = stringList.stream().collect(Collectors.toMap(s -> s, String::length));
        System.out.println(stringIntegerMap);
        Map<String, String> collect = stringList.stream().collect(Collectors.toMap(e -> e, String::trim));
        System.out.println(collect);

        HashMap<Integer, String> mapString = new HashMap<>();
        for (int i=0;i<stringList.size();i++)
        {
            mapString.put(i,stringList.get(i));
        }
        System.out.println(mapString);

        Map<Integer,String>mapStrings = Stream.iterate(0,e->e+1).limit(stringList.size()).collect(Collectors.toMap(e -> e, stringList::get));
        System.out.println(mapStrings);


        System.out.println("==============Here=================");
        List<Integer> integerList = Arrays.asList(12, 12, 34, 25, 67, 56);
        Map<Integer, Integer> integerMap = Stream.iterate(0, i -> i + 1).limit(integerList.size()).collect(Collectors.toMap(e -> e, integerList::get));
        System.out.println(integerMap);
        Map<Integer,Integer>mapInteger1=Stream.iterate(0,i->i+1).limit(integerList.size()).collect(Collectors.toMap(e->e,integerList::get));
        System.out.println(mapInteger1);

        Map<Integer,Integer>mapInteger=new HashMap<>();
        mapInteger.put(1,4);
        mapInteger.put(2,6);
        mapInteger.put(3,8);
        mapInteger.put(4,2);

        List<Integer> integers = mapInteger.entrySet().stream().map(e->e.getKey()).collect(Collectors.toList());
        System.out.println(integers);
        System.out.println("============");
        List<String> mapToList = mapInteger.entrySet().stream().map(e ->e.getKey()+":"+e.getValue()).collect(Collectors.toList());
        System.out.println(mapToList);

        List<String> names = Arrays.asList("A", "B", "A", "C");

        // Count occurrences of each letter using Java 8 Stream API
        Map<String, Long> nameCount = names.stream()
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));

        // Print the result
        nameCount.forEach((name, count) -> System.out.println(name + ": " + count));

        List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 6, 8, 3, 6, 7);
        numbers.forEach(System.out::println);
        System.out.println();
        numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();
        numbers.stream().sorted().distinct().collect(Collectors.toList()).forEach(System.out::println);

    }
}
