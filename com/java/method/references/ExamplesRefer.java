package com.java.method.references;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ExamplesRefer {
    public static void main(String[] args) {

        List<String>places= Arrays.asList("Muzaffarpur","Patna","Kolkata","Mumbai","Delhi");

        //using static method references concept//converting string into upper case
        List<String> stringList = places.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(stringList);

        System.out.println("=========Iterating through Iterator=======");
        Iterator<String>itr=stringList.iterator();
        while (itr.hasNext())
        {
            String next = itr.next();
            System.out.println(next);
        }

        System.out.println("======Iterating through ListIterator=======");
        ListIterator<String >listIterator=stringList.listIterator();
        while (listIterator.hasNext())
        {
            String next = listIterator.next();
            System.out.println(next);
        }

        //instance method refer
        System.out.println("Each word from given string");
        places.forEach(System.out::println);

        //constructor method-refer
        Supplier<List<String>>listSupplier= ArrayList::new;
        List<String> stringList1 = listSupplier.get();
        stringList1.addAll(places);
        System.out.println("Constructor: "+stringList1);

    }
}
