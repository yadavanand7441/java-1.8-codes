package com.java.nov_25.method_ref;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodRefExample1
{
    public static void main(String[] args) {

        List<String> words = Arrays.asList("Java", "Python", "Program", "C++", "HTML");

        // converting all word into upperCase
        List<String> upperCaseWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Uppercase words: "+upperCaseWords);
        upperCaseWords.forEach(System.out::println);
    }
}
