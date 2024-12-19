package com.java8features.streams;

import com.datastructures.gsprep.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class StreamPracticeMain {
    public static void main(String[] args) {
        List<Employee> employees = createEmployees();

        // 1. Male and Female employees
        maleAndFemale(employees);

        //2. Print the name of all the dept in organization
        departmentNames(employees);

        //3. What is the average age of male and female employees
        averageAgeOfMaleFemale(employees);

        //4. Get the details of highest paid employee in the organization
        highestPaid(employees);

        //5. Get names of all employees who have joined after 2015
        joinedAfter2015(employees);

        //6. Count the number of employees in each dept
        noOfEmployeesInEachDept(employees);

        //7. What is the average salary of each department?
        avgSalaryOfEachDept(employees);

        //8. Details of the youngest male employee in the product development department
        youngestInProdDevDept(employees);

        //9. Who has the most working experience in the organization
        mostWorkingExperience(employees);

        //10. How many male and female employees are there in the sales and marketing team
        maleFemaleCountInSalesTeam(employees);

        //11. What is the avg salary of male and female employees?
        avgSalaryOfMaleFemale(employees);

        //12. List down the names of all employees in each department
        namesOfEmployeesInEachDept(employees);

        //13. What is the average salary and total salary of the whole organization?
        avgAndTotalSalaryAndStats(employees);

        //14. Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        partitionYoungAndOld(employees);

        //15. Who is the oldest employee in the organization? What is his age and which department he belongs to?
        oldestEmployee(employees);

        //16. employee who works in Product Team and Is male member
        maleInProductTeam(employees);
    }

    private static void maleAndFemale(List<Employee> employees) {
        System.out.println("1----Total male and female employees-----");
        employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())).entrySet().forEach(System.out::println);
    }

    private static void departmentNames(List<Employee> employees) {
        System.out.println("2----Total department name-----");
        employees.stream().map(Employee::getDepartment).toList().forEach(System.out::println);
    }

    //Note down
    private static void averageAgeOfMaleFemale(List<Employee> employees) {
        System.out.println("3----Average age of Male & Female-----");
        employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge))).entrySet().forEach(System.out::println);
    }

    //Note down
    private static void highestPaid(List<Employee> employees) {
        System.out.println("4----Highest Paid-----");
        Employee employee = employees.stream().max(Comparator.comparing(Employee::getSalary)).get();
        System.out.println(employee);
    }

    private static void joinedAfter2015(List<Employee> employees) {
        System.out.println("5----Joined After 2015-----");
        List<Employee> emp = employees.stream().filter(e -> e.getYear() > 2015).toList();
        emp.forEach(System.out::println);
    }

    private static void noOfEmployeesInEachDept(List<Employee> employees) {
        System.out.println("6----Number of employees in each department-----");
        Map<String, Long> result = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        result.entrySet().forEach(System.out::println);
    }

    private static void avgSalaryOfEachDept(List<Employee> employees) {
        System.out.println("7----average salary of each department-----");
        Map<String, Double> result = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        result.entrySet().forEach(System.out::println);
    }

    private static void youngestInProdDevDept(List<Employee> employees) {
        System.out.println("8----youngest male employee in the product development department-----");
        Optional<Employee> result = employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase("Product Development")).min(Comparator.comparing(Employee::getAge)).stream().findFirst();
        result.ifPresent(System.out::println);
    }


    private static void mostWorkingExperience(List<Employee> employees) {
        System.out.println("9----most working experience in the organization-----");
        Optional<Employee> result = employees.stream().min(Comparator.comparing(Employee::getYear));
        result.ifPresent(System.out::println);
    }

    private static void maleFemaleCountInSalesTeam(List<Employee> employees) {
        System.out.println("10----male and female employees are there in the sales and marketing team-----");
        Map<String, Long> result = employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase("Sales And Marketing")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        result.entrySet().forEach(System.out::println);
    }

    private static void avgSalaryOfMaleFemale(List<Employee> employees) {
        System.out.println("11---- avg salary of male and female employees-----");
        Map<String, Double> result = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        result.entrySet().forEach(System.out::println);
    }

    private static void namesOfEmployeesInEachDept(List<Employee> employees) {
        System.out.println("12---- List down the names of all employees in each department-----");
        Map<String, List<Employee>> result = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        result.forEach((key, value) -> System.out.println(key + " " + value.stream().map(Employee::getName).toList()));
//        result.entrySet().forEach(v -> {
//            System.out.println(v.getKey() + " " + v.getValue().stream().map(Employee::getName).toList());
//        });
    }

    private static void avgAndTotalSalaryAndStats(List<Employee> employees) {
        System.out.println("13---- average salary and total salary of the whole organization-----");
//        Double result = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary)).getSum();
        Double[] value = employees.stream().collect(Collectors.teeing(Collectors.summarizingDouble(Employee::getSalary), Collectors.averagingDouble(Employee::getSalary), (total, average) -> new Double[]{total.getSum(), average}));
        System.out.println(value[0] + ": " + value[1]);
    }

    private static void partitionYoungAndOld(List<Employee> employees) {
        System.out.println("14---- Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.-----");
        Map<Boolean, List<Employee>> result = employees.stream().collect(Collectors.partitioningBy(c -> c.getAge() <= 25));
        result.forEach((k, v) -> {
            System.out.println(k ? "Young" : "Old");
            v.forEach(System.out::println);
        });
    }

    private static void oldestEmployee(List<Employee> employees) {
        System.out.println("15---- oldest employee in the organization? What is his age and which department he belongs to?.-----");
        Optional<Employee> result = employees.stream().max(Comparator.comparing(Employee::getAge));
        result.ifPresent(System.out::println);
    }

    private static void maleInProductTeam(List<Employee> employees) {
        System.out.println("16---- employee who works in Product Team and Is male member-----");
        List<Employee> result = employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase("Product Development") && e.getGender().equalsIgnoreCase("Male")).toList();
        result.forEach(System.out::println);
    }


    private static List<Employee> createEmployees() {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
        return employeeList;
    }
}
