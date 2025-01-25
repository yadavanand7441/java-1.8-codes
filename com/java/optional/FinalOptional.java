package com.java.optional;

import java.util.Optional;

public class FinalOptional {
    public static void main(String[] args) {

        String str="null";
        Optional<String> str1 = Optional.of(str);
        System.out.println(str1.orElse("no"));
        System.out.println(str1.map(s->Optional.of(str1)));
        System.out.println(str1.flatMap(s->Optional.ofNullable(str1)));
        //System.out.println(str1.get());
        str1.ifPresent(s-> System.out.println(s.toUpperCase()));
    }
}
