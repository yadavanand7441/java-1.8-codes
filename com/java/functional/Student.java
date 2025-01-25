package com.java.functional;

import com.java.functional.interfce.ExamplesInterface;

public class Student {
    public static void main(String[] args) {


        ExamplesInterface refer=(String name)->{
            return name;
        };
        System.out.println(refer.data("anand"));




    }
}
