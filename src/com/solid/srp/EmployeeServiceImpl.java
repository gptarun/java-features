package com.solid.srp;

import com.solid.Employee;

import java.util.List;

/**
 * ************************ READ ME ************************
 * Class maintaining the Employee related operations e.g. fetch, update or delete data
 * However, sending email to employee should be the separate responsibility.
 * Hence, this class is breaking the SRP principle due to sendMail method.
 * <p>
 * Now EmployeeServiceImpl having 2 reasons to change:
 * 1. Employee CRUD operation
 * 2. Sending Mails to employee
 * </p>
 */
public class EmployeeServiceImpl {
    public String getDesignation(int employeeId, List<Employee> employeeList) {
        return employeeList.stream()
                .filter(employee -> employee.getId() == employeeId)
                .map(Employee::getDepartment).findFirst()
                .orElse(null);
    }

    public boolean updateSalary(int id, int newSalary, List<Employee> employeeList) {
        return employeeList.stream().filter(e -> e.getId() == id).findFirst().map(employee -> {
            employee.setSalary(newSalary);
            return true;
        }).orElse(false);
    }

    public void sendMail(List<Employee> employeeList) {
        employeeList.forEach(employee -> {
            System.out.println("Mail sent to " + employee.getName());
        });
    }
}
