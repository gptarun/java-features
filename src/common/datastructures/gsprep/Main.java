package common.datastructures.gsprep;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    /**
     * Finds the first character that does not repeat anywhere in the input string
     * Given "apple", the answer is "a"
     * Given "racecars", the answer is "e"
     **/
    public static void main(String[] args) {
        String input = "apple";
//        System.out.println(firstNonRepeatingChar("apple"));
//        System.out.println(firstNonRepeatingChar("racecars"));
//        System.out.println(firstNonRepeatingChar("aabbcd"));


        List<Employee> employeeList = new ArrayList<Employee>();

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
        employeeList.add(new Employee(255, "Anuj Chettiar", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Anuj Chettiar", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

//        Query 3.1 : How many male and female employees are there in the organization?
//        Query 3.3 : What is the average age of male and female employees?
//        Query 3.5 : Get the names of all employees who have joined after 2015?
        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())));
        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge))));
        employeeList.stream().filter(e -> e.getYear() > 2015).map(Employee::getName).forEach(System.out::println);
    }

    public static char firstNonRepeatingChar(String input) {
        LinkedHashMap<Character, Long> charCounts = new LinkedHashMap<>();
        char[] inputCharArray = input.toCharArray();
        for (int i = 0; i < inputCharArray.length; i++) {
            charCounts.put(inputCharArray[i], (charCounts.getOrDefault(inputCharArray[i], 0L) + 1));
        }
        for (Map.Entry<Character, Long> entry : charCounts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        //Option 1
        Map<Character, Long> charCountMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
        //Option 2
        LinkedHashMap<Character, Long> val = input.chars().mapToObj(c -> (char) c).collect(Collectors.toMap(Function.identity(), c -> 1L, Long::sum, LinkedHashMap::new));
        Map.Entry<Character, Long> ans = val.entrySet().stream().filter(value -> value.getValue() == 1).findFirst().get();
        return (char) -1;
    }

    //    10 -> 20 -> 30 -> 40 -> 50 -> 60
//    n/2 +1
    public static Node findMiddle(Node head) {
        if (head != null) {
            return null;
        }
        Node firstNode = head;
        int length = 0;
        while (head != null && head.next != null) {
            Node next = head.next;
            head.next = next.next;
            length++;
        }
        int mid = 0;
        if (length % 2 == 0) {
            mid = length / 2 + 1;
        } else {
            mid = (length + 1) / 2;
        }
        while (mid > 0 && firstNode != null && firstNode.next != null) {
            mid--;
            Node next = firstNode.next;
            firstNode.next = next.next;
        }
        return firstNode;
    }
}
