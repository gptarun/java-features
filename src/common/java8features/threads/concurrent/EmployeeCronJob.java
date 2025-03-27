package common.java8features.threads.concurrent;

import common.solid.Employee;

public class EmployeeCronJob implements Runnable {

    @Override
    public void run() {
        System.out.println(fetchEmployee());
    }

    public Employee fetchEmployee() {
        return new Employee(1, "T", "D", 200);
    }
}
