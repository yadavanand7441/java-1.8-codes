package com.java.nov_25.stream_api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Employee
{
    private int id;
    private String name;
    private double salary;
    private String department;
    private String address;

    public Employee(int id, String name, double salary, String department, String address) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.address = address;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


    public static void main(String[] args) {

        ArrayList<Employee> empList = new ArrayList<>();
        empList.add(new Employee(101, "Rajesh Kumar", 45000.50, "IT", "Delhi"));
        empList.add(new Employee(102, "Priya Sharma", 52000.75, "HR", "Mumbai"));
        empList.add(new Employee(103, "Amit Verma", 48000.00, "Finance", "Pune"));
        empList.add(new Employee(104, "Neha Gupta", 51000.25, "Marketing", "Bangalore"));
        empList.add(new Employee(105, "Suresh Singh", 60000.00, "Operations", "Kolkata"));
        empList.add(new Employee(105, "Suresh Singh", 60000.00, "Operations", "Kolkata"));
        empList.add(new Employee(106, "Anjali Mehta", 47000.80, "Sales", "Chennai"));

        System.out.println("======highest employee salary=======");
        Employee maxSalariedEmployee = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(0).findFirst().orElse(null);
        System.out.println(maxSalariedEmployee);

        System.out.println("========lowest salary employee==========");
        Employee minimumSalariedEmployee = empList.stream().sorted(Comparator.comparing(Employee::getSalary)).skip(0).findFirst().orElse(null);
        System.out.println(minimumSalariedEmployee);

        System.out.println("========skip duplicate name employee and fetched all highest salary==========");
        Map<String, Optional<Employee>> stringOptionalMap = empList.stream().collect(Collectors.groupingBy(Employee::getName,
                Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        stringOptionalMap.forEach((name, empOpt) -> {
            empOpt.ifPresent(emp ->
                    System.out.println("ID: "+emp.getId()+ "," +"Name: " + name + ", Highest Salary: " + emp.getSalary()
                            + ", Department: " + emp.getDepartment() + ", Address: " + emp.getAddress()));
        });

        System.out.println("========fetch all records sorted by name and then salary==========");
        empList.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary)).forEach(System.out::println);

        System.out.println("========employee with longest name record==========");
        Employee longestName = empList.stream().max(Comparator.comparing(e -> e.getName().length())).orElse(null);
        System.out.println(longestName);

        System.out.println("========sum of all employee salary==========");
        double sum = empList.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(sum);

        System.out.println("========average salary ==========");
        Double averageSalary = empList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(averageSalary);

        System.out.println("========count employee salary > 50k==========");
        long count = empList.stream().filter(e -> e.getSalary() > 50000).count();
        System.out.println(count);

        System.out.println("========fetch 3 highest paid salary employee==========");
        empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).forEach(System.out::println);

        System.out.println("========covert salary list to sorted unique list==========");
        empList.stream().map(Employee::getSalary).sorted().distinct().forEach(System.out::println);

    }
}
