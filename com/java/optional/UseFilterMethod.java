package com.java.optional;

import java.util.Optional;
import java.util.function.Predicate;

public class UseFilterMethod {
    public static void main(String[] args) {

        Optional<String> hello_wold = Optional.of("Hello Wolds");
        Optional<String> empty = Optional.empty();

        Predicate<String>isLonger=str->str.length()>10;
        Optional<String> result1 = hello_wold.filter(isLonger);
        Optional<String> result2 = empty.filter(isLonger);

        result1.ifPresent(v-> System.out.println("Result1: "+result1));
        result2.ifPresent(v-> System.out.println("Result2: "+result2));
    }
}
