package com.solid.srp;

import com.solid.Employee;

import java.util.List;

/**
 * ************************ READ ME ************************
 * S — Single Responsibility Principle (known as SRP)
 * class should be having one and only one responsibility
 */
public class SingleResponsibilityMain {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "Sam", "HR", 100),
                new Employee(2, "Alex", "IT", 200)
        );
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        System.out.println(employeeService.getDesignation(2, employees));
        System.out.println(employeeService.updateSalary(2, 400, employees));
        employeeService.sendMail(employees);
    }
}
