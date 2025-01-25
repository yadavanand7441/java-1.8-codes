package com.java.lambda;

import com.java.entity.Student;
import com.java.functional.interfce.StudentMainInterface;
import com.java.impl.StudentData;

public class StudentMain {

    public static void main(String[] args) {

        StudentData studentData= new StudentData();
        StudentMainInterface studentMainInterface= ()-> studentData.createStudent();

        Student st= studentMainInterface.getStudent();
        System.out.println(st);


    }
}
