package com.java.stream.api;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Employee {
    private int id;
    private String name;
    private String address;
    private double salary;

    public Employee(int id, String name, String address, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {

        Employee e1=new Employee(123,"Suman","Patna",25342.83);
        Employee e2=new Employee(4,"Ranjit","Mumbai",2513254.0);
        Employee e3=new Employee(7,"Ram","Ayodhya",231525.09);
        Employee e4=new Employee(8,"Radha","RawalGao",25132.323);
        Employee e5=new Employee(9,"Geeta","Delhi",36241.03);
        Employee e6=new Employee(6,"Sima","Goa",25234121.0);
        Employee e7=new Employee(9,"Bhola","Kolkata",252342.09);

        List<Employee>employeeList=new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
        employeeList.add(e6);
        employeeList.add(e7);

        List<Employee> empList = new ArrayList<>();
        empList.add(e2);

        System.out.println("=====All Employee====");
        employeeList.stream().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("===== Employee with even ID filter used here ====");
        employeeList.stream().filter(e->e.getId()%2==0).forEach(System.out::println);
        System.out.println("=====All Employee sorted based on ID====");
        employeeList.stream().sorted((p1,p2)->Integer.compare(p1.getId(),p2.getId())).forEach(System.out::println);


        System.out.println("===========method now using=============");
        boolean allMatch = employeeList.stream().allMatch(e -> e.getId() >4);
        System.out.println("allMatch:"+allMatch);
        boolean allMatch1 = employeeList.stream().allMatch(e -> e.getId() >= 4);
        System.out.println("allMatch1: "+allMatch1);
        boolean anyMatch = employeeList.stream().anyMatch(e -> e.getId() < 5);
        System.out.println("anyMatch:"+anyMatch);
        boolean noneMatch = employeeList.stream().noneMatch(e -> e.getId() == 4);
        System.out.println("noneMatch: "+noneMatch);

        System.out.println("===========method now using concat with two object=============");
        Stream<Employee> employeeStream1 = employeeList.stream();
        Stream<Employee> employeeStream2 = empList.stream();
        Stream<Object> concatStream = Stream.concat(employeeStream1.map(Objects::toString), employeeStream2);
        concatStream.forEach(System.out::println);

        //count now
        System.out.println("===========method now using count=============");
        concatStream=Stream.concat(employeeList.stream(),empList.stream());
        long count = concatStream.count();
        System.out.println("count: "+count);

        System.out.println("===========method now using distinct=============");
        employeeList.stream().sorted(Comparator.comparing(Employee::getId)).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("===========method now using findFirst=============");
        employeeList.stream().filter(e->e.getId()==e.getId()).findFirst().ifPresent(System.out::println);
        System.out.println("===========method now using flatMap=============");
        employeeList.stream().flatMap(e-> Arrays.asList(e.getId()).stream()).distinct().forEach(System.out::println);
        System.out.println("===========method now using flatMap with all record=============");
        employeeList.stream().flatMap(e-> Arrays.asList(e.getId()+":"+e.getName()).stream()).distinct().forEach(System.out::println);

        System.out.println("===========method now using Map=============");
        employeeList.stream().map(c->"Id: "+c.getId()+" name:"+c.getName()+" salary: "+c.getSalary()+" " +
                "address: "+c.getAddress()).forEach(System.out::println);
        System.out.println("====================");
        employeeList.stream().map(e-> e.getName()).distinct().forEach(System.out::println);
        System.out.println("sorted with id");
        employeeList.stream().map(Employee::getId).sorted().forEach(System.out::println);
        System.out.println("=======sorted with name=======");
        employeeList.stream().map(Employee::getName).sorted().forEach(System.out::println);
        System.out.println("=======sorted with price and fetch all name=======");
        employeeList.stream().sorted((p1,p2)->Double.compare(p1.getSalary(), p2.getSalary())).forEach(p->System.out.println(p.getName()));
        System.out.println("=======sorted with price and fetch all price=======");
        employeeList.stream().sorted((p1,p2)->Double.compare(p1.getSalary(), p2.getSalary())).forEach(e-> System.out.println(e.getSalary()));





    }
}
