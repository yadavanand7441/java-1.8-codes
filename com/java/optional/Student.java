package com.java.optional;


import java.util.Optional;
import java.util.stream.Collectors;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {

        Student student=new Student(121,"Priyanshu",10);

        // if the values is present
        Optional<Student> student1 = Optional.ofNullable(student);
        student1.ifPresent(s-> System.out.println("Student ID: "+s.getId()+" Name: "+s.getName()+" Age: "+s.getAge()));

        //if optional is null
        Optional<Student> op = Optional.ofNullable(null);
        op.ifPresent(p-> System.out.println("ID: "+p.getId()+" Name: "+p.getName()+" Age: "+p.getAge()));


        /*System.out.println(student1.isEmpty());
        System.out.println(student1.isPresent());
        System.out.println(student);*/

        Student orElse = student1.orElse(new Student(0, "default", 0));
        System.out.println("Student data: "+orElse);

        student1.stream().forEach(s-> System.out.println("Student ID: "+s.getId()+":"+s.getName()+": "+s.getAge()));
    }
}
