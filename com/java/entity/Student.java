package com.java.entity;

import java.util.List;

public class Student {
    int id;
    String name;
    String address;

    List<String>schools;

    public Student(int id, String name, String address, List<String> schools) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.schools = schools;
    }

    public Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", schools=" + schools +
                '}';
    }

}
