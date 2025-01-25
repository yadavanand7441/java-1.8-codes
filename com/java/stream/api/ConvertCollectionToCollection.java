package com.java.stream.api;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertCollectionToCollection {
    public static void main(String[] args) {

        List<Integer>listInteger=new ArrayList<>();
        listInteger.add(234); listInteger.add(234); listInteger.add(234);
        listInteger.add(234);listInteger.add(234);listInteger.add(234);

        System.out.println("fetch index and value after converting to map");
        Map<Integer, Integer> integerMap = Stream.iterate(0, i -> i + 1).limit(listInteger.size()).collect(Collectors.toMap(e -> e, listInteger::get));
        System.out.println(integerMap);

        List<String> stringList = Arrays.asList("Anand", "Radha", "Mohan", "Sohan");

        System.out.println("fetch record with length and convert to map");
        Map<String, Integer> stringMap = stringList.stream().collect(Collectors.toMap(e -> e, String::length));
        System.out.println(stringMap);
        Map<Integer, String> mapString = Stream.iterate(0, i -> i + 1).limit(stringList.size()).collect(Collectors.toMap(e -> e, stringList::get));
        System.out.println(mapString);

        Map<Integer,Integer>mapInteger=new HashMap<>();
        mapInteger.put(1,4);
        mapInteger.put(2,6);
        mapInteger.put(3,8);
        mapInteger.put(4,2);

        System.out.println("====only key=====");
        List<Integer> integerList = mapInteger.entrySet().stream().map(e -> e.getKey()).collect(Collectors.toList());
        System.out.println(integerList);
        System.out.println("====only value=====");
        mapInteger.entrySet().stream().map(e->e.getValue()).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("====converting map to set=====");
        Set<Integer> integerSet = mapInteger.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toSet());
        System.out.println(integerSet);




    }
}
