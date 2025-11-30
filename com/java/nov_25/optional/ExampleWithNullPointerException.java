package com.java.nov_25.optional;

import java.util.Optional;

public class ExampleWithNullPointerException
{
    public static void main(String[] args) {

        // throwing NullPointerException with below Example
        String string1=null;
        System.out.println(string1.length());

        // fix this issue with Optional
        Optional<String>stringOptional = Optional.ofNullable(null);
        System.out.println(stringOptional.orElse("string not found").length());
    }
}
