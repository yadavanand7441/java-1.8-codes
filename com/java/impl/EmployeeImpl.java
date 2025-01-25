package com.java.impl;

import com.java.entity.Employee;
import com.java.functional.interfce.EmployeeInterface;

import java.util.ArrayList;
import java.util.List;

public class EmployeeImpl {

    public static List<Employee>getEmployeeList(EmployeeInterface employeeInterface)
    {
        return employeeInterface.getEmployee();
    }

    public static List<Employee>generateEmployee()
    {
        List<Employee>employees= new ArrayList<>();
        employees.add(new Employee(12123,"Anand Yadav",2413252.342,List.of("Patna,Pune","Mumbai","Delhi")));
        employees.add(new Employee(12123,"Anand Yadav",2413252.342,List.of("Patna,Pune","Mumbai","Delhi")));
        return employees;
    }
}
