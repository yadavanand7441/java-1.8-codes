package com.java.march_26.optional;

import java.util.Optional;

public class OptionalMethod {
    public static void main(String[] args) {

        String str1="Radha";
        String str2="Krishna";

        Optional<String>optional1= Optional.ofNullable(str1);
        Optional<String>optional2= Optional.ofNullable(str2);
        System.out.println(optional1);
        System.out.println(optional1.isEmpty());
        System.out.println(optional2.isPresent());
        System.out.println(optional1.equals(optional2));


        // filter example
        System.out.println("=====filter example=====");
        Optional<String> filter = optional1.filter(s -> s.length() > 3);
        System.out.println(filter);
        System.out.println("====");
        Optional<String> radha = optional1.filter(s -> s.matches("Radha"));
        System.out.println(radha);

        // flatMap example
        System.out.println("=====flatMap example=====");
        Optional<String> upperCase = optional1.flatMap(s -> Optional.ofNullable(s.toUpperCase()));
        System.out.println(upperCase);
        Optional<Integer> integerLength = optional1.flatMap(p -> Optional.of(p.length()));
        System.out.println(integerLength);
        Optional<Boolean> equalsMethod = optional1.flatMap(p -> Optional.of(p.equals(optional2)));
        System.out.println(equalsMethod);
        Optional<Integer> integer1 = optional1.flatMap(s -> Optional.of(s.length()));
        System.out.println(integer1);

        // map example
        System.out.println("=====map example=====");
        System.out.println(optional1.map(s->s.toUpperCase()));
        System.out.println(optional1.map(s->s.getBytes()));
        System.out.println(optional1.map(s->s.codePointAt(2)));
        Optional<Optional<Integer>> integer = optional1.map(s -> Optional.of(s.length()));
        System.out.println(integer);
    }
}
