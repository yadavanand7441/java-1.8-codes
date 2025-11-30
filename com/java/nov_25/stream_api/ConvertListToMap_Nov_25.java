package com.java.nov_25.stream_api;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertListToMap_Nov_25 {

    public static void main(String[] args) {

        List<String> stringList=new ArrayList<>();
        stringList.add("Anand");
        stringList.add("Mohan");
        stringList.add("Rohini");
        stringList.add("Sohan");
        stringList.add("Sonu");

        Map<String, Integer> listMap = stringList.stream().collect(Collectors.toMap(s -> s, String::length));
        System.out.println(listMap);

        Map<String, String> collect = stringList.stream().collect(Collectors.toMap(e -> e, String::trim));
        System.out.println(collect);

        HashMap<Integer, String> listToMap = new HashMap<>();
        for (int i=0;i<stringList.size();i++)
        {
            listToMap.put(i,stringList.get(i));
        }
        System.out.println(listToMap);

        System.out.println("======java-1.8 from here======");
        Map<Integer, String> stringMap = Stream.iterate(0, e -> e + 1).limit(stringList.size()).collect(Collectors.toMap(e -> e, stringList::get));
        System.out.println(stringMap);

        List<Integer> integerList = Arrays.asList(12, 12, 34, 25, 67, 56);
        Map<Integer, Integer> integerMap = Stream.iterate(0, e -> e + 1).limit(integerList.size()).collect(Collectors.toMap(e -> e, integerList::get));
        System.out.println(integerMap);


        HashMap<Integer, Integer> mapInteger = new HashMap<>();
        mapInteger.put(1,231);
        mapInteger.put(2,452);
        mapInteger.put(3,121);
        mapInteger.put(4,16);
        mapInteger.put(5,645);
        mapInteger.put(6,23);

        System.out.println("======mapToList=========");
        mapInteger.entrySet().stream().map(e->e.getKey()+":"+e.getValue()).collect(Collectors.toList()).forEach(System.out::println);
        Optional<Map.Entry<Integer, Integer>> max = mapInteger.entrySet().stream().max(Map.Entry.comparingByValue());
        System.out.println(max);

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
