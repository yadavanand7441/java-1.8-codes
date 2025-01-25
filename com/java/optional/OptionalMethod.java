package com.java.optional;

import java.util.Locale;
import java.util.Optional;

public class OptionalMethod {
    public static void main(String[] args) {

        String str1="Radha";
        String str2="Radha";
        Optional<String> str11 = Optional.ofNullable(str1);
        Optional<String> str22 = Optional.ofNullable(str2);

        System.out.println(str11.isEmpty());
        System.out.println(str11.get());
        System.out.println(str22.equals(str11));

        // filter example
        System.out.println("=====filter example=====");
        Optional<String> filter = str11.filter(s -> s.length() > 3);
        System.out.println(filter);
        System.out.println("====");
        Optional<String> radha = str11.filter(s -> s.matches("Radhas"));
        System.out.println(radha);

        // flatMap example
        System.out.println("=====flatMap example=====");
        Optional<String> upperCase = str11.flatMap(s -> Optional.ofNullable(s.toUpperCase()));
        System.out.println(upperCase);
        Optional<Integer> integerLength = str11.flatMap(p -> Optional.of(p.length()));
        System.out.println(integerLength);
        Optional<Boolean> equalsMethod = str11.flatMap(p -> Optional.of(p.equals(str22)));
        System.out.println(equalsMethod);
        Optional<Integer> integer1 = str11.flatMap(s -> Optional.of(s.length()));
        System.out.println(integer1);

        // map example
        System.out.println("=====map example=====");
        System.out.println(str11.map(s->s.toUpperCase()));
        System.out.println(str11.map(s->s.getBytes()));
        System.out.println(str11.map(s->s.codePointAt(2)));
        Optional<Optional<Integer>> integer = str11.map(s -> Optional.of(s.length()));
        System.out.println(integer);


    }
}
