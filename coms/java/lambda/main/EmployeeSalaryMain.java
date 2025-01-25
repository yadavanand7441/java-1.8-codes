package coms.java.lambda.main;

import coms.java.lambda.interfc.EmployeeInterfaceSalary;

public class EmployeeSalaryMain {
    public static void main(String[] args) {

        EmployeeInterfaceSalary salary = (emp)->{
            return emp;
        };
        System.out.println(salary.employeeSalary(234123.4654));



    }
}
