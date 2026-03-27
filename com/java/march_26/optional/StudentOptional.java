package com.java.march_26.optional;


import java.util.Optional;

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
        StudentOptional student=new StudentOptional(12,"Krishna",16);
        // if the values is present
        Optional<StudentOptional>studentOptional=Optional.ofNullable(student);
        System.out.println(studentOptional.isPresent());
        studentOptional.ifPresent(s-> System.out.println(s.getId()+s.getName()+s.getAge()));

        //if optional is null
        Optional<StudentOptional>os=Optional.ofNullable(null);
        os.ifPresent(s-> System.out.println(s.getId()+" "+s.getName()+" "+s.getAge()));

        StudentOptional orElse = studentOptional.orElse(new StudentOptional(0, "default", 0));
        System.out.println("Student data: "+orElse);
    }
}
