package com.java.march_26.streamapi;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class Employee {

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
        empList.add(new Employee(105, "Priya Sharma", 52000.75, "HR", "Mumbai"));
        empList.add(new Employee(103, "Amit Verma", 48000.00, "Finance", "Pune"));
        empList.add(new Employee(106, "Neha Gupta", 51000.25, "Marketing", "Bangalore"));
        empList.add(new Employee(105, "Suresh Singh", 60000.00, "Operations", "Kolkata"));
        empList.add(new Employee(102, "Suresh Singh", 60000.00, "Operations", "Kolkata"));
        empList.add(new Employee(104, "Anjali Mehta", 47000.80, "Sales", "Chennai"));

        System.out.println("=====Find employee with given id=====");
        empList.stream().filter(e->e.id==102).forEach(System.out::println);
        empList.stream().filter(e->e.getId()==101).forEach(System.out::println);
        System.out.println("=====Find employee with given id=====not null safe");
        Employee employeeWithNotNullSafe = empList.stream().filter(e -> e.getId() == 103).findFirst().get();
        System.out.println(employeeWithNotNullSafe);
        System.out.println("=====Find employee with given id===== null safe");
        Optional<Employee> employeeOptional = empList.stream().filter(e -> e.id == 1002).findFirst();
        System.out.println(employeeOptional);
        System.out.println("======All id's >2=====");
        empList.stream().filter(e->e.id>102).map(m->m.id).forEach(System.out::println);
        System.out.println("============All Id's==============");
        empList.stream().map(Employee::getId).forEach(System.out::println);
        System.out.println("=======By name=========not null safe");
        Employee employeeByName = empList.stream().filter(e -> e.name == "Suresh Singh").findFirst().get();
        System.out.println(employeeByName);
        System.out.println("=======By name=========null safe");
        Optional<Employee> employeeByNameNullSafe = empList.stream().filter(e -> e.getName() == "Anjali Mehtas").findFirst();
        System.out.println(employeeByNameNullSafe);
        System.out.println("=====all name only=======");
        empList.stream().map(Employee::getName).forEach(System.out::println);
        System.out.println("=========All sorted id==========");
        empList.stream().map(Employee::getId).sorted().forEach(System.out::println);
        System.out.println("======all record sorted by id======");
        empList.stream().sorted(Comparator.comparing(Employee::getId)).forEach(System.out::println);
        System.out.println("=========all record sorted by name==========");
        empList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
        System.out.println("=========all record which salary is >? Rs.==========");
        empList.stream().filter(salary->salary.getSalary()>48000).forEach(System.out::println);
        System.out.println("======highest salary employee=====");
        Employee employeeHighestSalary = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(0).findFirst().orElse(null);
        System.out.println(employeeHighestSalary);
        System.out.println("======2nd highest salary employee=====");
        Employee employeeWithSecondHighestSalary = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().orElse(null);
        System.out.println(employeeWithSecondHighestSalary);
        System.out.println("======3rd lowest salary employee=====");
        Employee employee3rdLowestSalary = empList.stream().sorted(Comparator.comparing(Employee::getSalary)).skip(2).findFirst().orElse(null);
        System.out.println(employee3rdLowestSalary);
        System.out.println("========fetch all records sorted by name and then salary==========");
        empList.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary)).forEach(System.out::println);
        System.out.println("========employee with longest name record==========");
        Employee maxLengthEmployee = empList.stream().max(Comparator.comparing(e -> e.getName().length())).orElse(null);
        System.out.println(maxLengthEmployee);
        System.out.println("========sum of all employee salary==========");
        double sumOfAllEmployeeSalary = empList.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(sumOfAllEmployeeSalary);
        System.out.println("========average salary ==========");
        Double averageSalary = empList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(averageSalary);
        System.out.println("========count employee salary > 50k==========");
        long countEmployee = empList.stream().filter(e -> e.getSalary() > 50000).count();
        System.out.println(countEmployee);
        System.out.println("========fetch 3 highest paid salary employee==========");
        Employee employee3rd = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).findFirst().orElse(null);
        System.out.println(employee3rd);
        System.out.println("========covert salary list to sorted unique list==========");
        empList.stream().map(Employee::getSalary).sorted().distinct().forEach(System.out::println);

    }
}
