package coms.java.lambda.main;

import coms.java.lambda.interfc.StudentInter;

public class Student {
    public static void main(String[] args) {

        StudentInter studentInter= (s)->{
            return (int) s;
        };
        System.out.println(studentInter.name(23.4));


    }
}
