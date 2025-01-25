package com.java.optional;

import java.util.Optional;

public class OptionalOfNullableEmpty {

    public static void main(String[] args) {

       /* Optional<String> optional1 = Optional.of("Hello"); // it must have at least non-null value
        Optional<String> optional2 = Optional.ofNullable("world"); // it should also have one non-null value
        Optional<String> optional3 = Optional.empty();

        System.out.println(optional1.isEmpty());
        System.out.println(optional2.isEmpty());
        System.out.println(optional3.isEmpty());

        System.out.println("======Others========");
        String str1=null;
        String str2=null;
        String str3="Anand";
        //Optional<String> optional4 = Optional.of(str1);
        Optional<String> optional5 = Optional.ofNullable(str2);
        Optional<String> optional6 = Optional.empty();

        *//*System.out.println(optional4.isEmpty());
        System.out.println(optional5.isEmpty());
        System.out.println(optional6.isEmpty());*//*

        *//*System.out.println(optional4.isPresent());
        System.out.println(optional5.isPresent());
        System.out.println(optional6.isPresent());*//*

        //System.out.println(optional4.orElse("Nothing is present in string"));
        System.out.println(optional5.orElse("Nothing is present in string"));
        System.out.println(optional6.orElse("Nothing is present in string"));*/

        String str=null;

        // Optional.of(); should always contain a value otherwise it will throw nullPointerException
        /*Optional<String> optional1 = Optional.of(str);
        System.out.println(optional1.get());
        System.out.println(optional1.orElse("mine no"));*/

        Optional<String> optional2 = Optional.ofNullable(str);
        System.out.println(optional2.isEmpty());
        System.out.println(optional2.isPresent());
        System.out.println(optional2.orElse("mine is nothing instead of God !!"));
        optional2.ifPresent(s-> System.out.println(s.length()));
        //System.out.println(optional2.get());

        Optional<String> empty = Optional.empty();
        System.out.println(empty.isEmpty());


    }
}
