package com.java.lambda;

import com.java.entity.Employee;
import com.java.functional.interfce.EmployeeInterface;
import com.java.impl.EmployeeImpl;

import java.util.List;

public class EmployeeMain {
    public static void main(String[] args) {


        EmployeeInterface employeeInterface=()->{
            return EmployeeImpl.generateEmployee();
        };
        List<Employee> employee= EmployeeImpl.getEmployeeList(employeeInterface);
        employee.forEach(System.out::println);

    }
}
