package com.java.optional;

import java.util.*;

public class StudentOptional {
    private int id;
    private String name;
    private int age;

    public StudentOptional(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentOptional that = (StudentOptional) o;
        return id == that.id && age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "StudentOptional{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {

        StudentOptional studentOptional1=new StudentOptional(123,"Tony",12);
        StudentOptional studentOptional2=new StudentOptional(123,"Tony",12);

        List<StudentOptional>optionalList=new ArrayList<>();
        optionalList.add(studentOptional1);
        optionalList.add(studentOptional2);
        Optional<List<StudentOptional>> list = Optional.ofNullable(optionalList);
        //Optional<List<StudentOptional>> list = Optional.ofNullable(null);


        Optional<StudentOptional> optional1 = Optional.ofNullable(studentOptional1);
        Optional<StudentOptional> optional2 = Optional.ofNullable(studentOptional2);

        System.out.println("=====fetching all records=========");
        optional1.ifPresent(e-> System.out.println("Student: "+e.getId()+" "+e.getName()+" "+e.getAge()));
        System.out.println("=====using equals method=========");
        System.out.println(optional2.equals(optional1));
        System.out.println(optional1);
        System.out.println(optional2);
        Optional<Integer> integer = optional2.flatMap(e -> Optional.of(e.age));
        System.out.println(integer);
        System.out.println("========flatMap========");
        list.flatMap(e -> Optional.ofNullable(e)).orElse(Collections.emptyList()).forEach(System.out::println);
        System.out.println("=======orElse=======");
        list.orElse(Collections.emptyList()).forEach(System.out::println);

        System.out.println("======map========");
        list.map(e->e).orElse(Collections.emptyList()).forEach(System.out::println);
        Optional<Optional<String>> s = optional1.map(e -> Optional.of(e.getName()));
        System.out.println(s);


    }
}
