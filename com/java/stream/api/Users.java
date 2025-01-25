package com.java.stream.api;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private int id;
    private String name;
    private int age;

    public Users(int id, String name, int age) {
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
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {


        List<Users> usersName = new ArrayList<>();
        usersName.add(new Users(123,"Sonu",12));
        usersName.add(new Users(123,"Sonu",12));
        usersName.add(new Users(123,"Sonu",12));
        usersName.add(new Users(123,"Sonu",12));
        usersName.add(new Users(123,"Sonu",12));
        usersName.add(new Users(123,"Sonu",12));


        List<Users> list = usersName.stream().collect(Collectors.toList());
        System.out.println(list);

        usersName.stream().max(Comparator.comparing(Users::getId)).ifPresent(System.out::println);
        usersName.stream().mapToInt(Users::getId).max().ifPresent(System.out::println);

    }
}
