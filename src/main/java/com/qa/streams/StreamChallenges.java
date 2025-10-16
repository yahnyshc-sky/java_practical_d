package com.qa.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamChallenges {

// ToDo A
//        1. Create a list of doubles called nums with the values 2.5, 9.0, 4.3, 7.5, 2.4
//        2. Print the list
//        3. Using the Streams API calculate the average of the list, otherwise return 0.0
//        4. Print the average value
    public static void taskA(){
        List<Double> nums = new ArrayList<>(List.of(2.5, 9.0, 4.3, 7.5, 2.4));

        nums.stream().forEach(System.out::println);

        Double avg = nums
                .stream()
                .collect(Collectors.averagingDouble(d -> d));

        System.out.println("Average value: " + avg);
    }

// ToDo B
//        1. Create a list of ints called nums with the values 64, 33, 82, 95, 70, 12, 17, 41, 96
//        2. Print the list
//        3. Using the Streams API extract only even numbers from the list into a new list
//        4. Print the even numbers
//        5. Using the Streams API extract only odd numbers from the list into a new list
//        6. Print the odd numbers

    public static void taskB(){
        List<Integer> nums = new ArrayList<>(List.of(64, 33, 82, 95, 70, 12, 17, 41, 96));
        System.out.println("ORIGINAL LIST");
        nums.forEach(System.out::println);
        System.out.println("EVEN LIST");
        List<Integer> evenList = nums.stream().filter(n -> n % 2 == 0).toList();
        evenList.forEach(System.out::println);
        System.out.println("ODD LIST");
        List<Integer> oddList = nums.stream().filter(n -> n % 2 == 1).toList();
        oddList.forEach(System.out::println);
    }

// ToDo C
//        1. Create a list of ints called nums with the values 64, 33, 82, 95, 70, 82, 70, 41, 33
//        2. Print the list
//        3. Using the Streams API remove duplicates and add the unique values to a new list
//        4. Print the new unique list

    public static void taskC(){
        List<Integer> numbers = new ArrayList<>(List.of(64, 33, 82, 95, 70, 82, 70, 41, 33));
        numbers.forEach(s -> System.out.print(s +" "));
        List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("\n Unique List: ");
        uniqueNumbers.forEach(s -> System.out.print(s +" "));


    }
// ToDo D
//        1. Create a list of ints called nums with the values 10, 15, 0, 6, 11, -3
//        2. Print the list
//        3. Using the Streams API find the highest value in the list
//        4. Using the Streams API find the lowest value in the list
//        5. Print the two values
    public static void taskD(){
        List<Integer> nums = new ArrayList<>(List.of(10, 15, 0, 6, 11, -3));
        nums.forEach(s -> System.out.print(s +" "));
        int maxNum = nums.stream().max(Integer::compare).get();
        int minNum = nums.stream().min(Integer::compare).get();

        System.out.println(" ");
        System.out.println("MAX NUMBER: " + maxNum);
        System.out.println("MIN NUMBER: " + minNum);
    }

// ToDo E
//        1. Create a list of Employees called employeeList
//        2. Populate with appropriate sample data for name, age, salary and totalDaysLeave
//        3. Using the Streams API summarize the age statistics
//        4. Using the Streams API summarize the salary statistics
//        5. Using the Streams API summarize the totalDaysLeave statistics
//        6. Experiment with filtering the list by name, age, salary and daysLeave
    public static void taskE(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Daveraj", 35, 100000.5, 7L));
        employeeList.add(new Employee("Maks", 45, 100000.6, 8L));

        String age_summary =  employeeList
                .stream()
                .collect(Collectors.summarizingInt(e -> e.getAge())).toString();

        System.out.println(age_summary);

        String salary_summary =  employeeList
                .stream()
                .collect(Collectors.summarizingDouble(e -> e.getSalary())).toString();

        System.out.println(salary_summary);

        String leave_summary =  employeeList
                .stream()
                .collect(Collectors.summarizingLong(e -> e.getDaysLeave())).toString();

        System.out.println(leave_summary);

        Predicate<Employee> salary_filter = e -> e.getSalary() > 100000.5;

        System.out.println(employeeList.stream().filter(salary_filter).collect(Collectors.toList()));
    }

// ToDo F
//        1. Do further research on the Streams API
//        2. Create examples to consolidate and demonstrate your understanding
//        3. Suggestions: peek, limit, count, takeWhile, skip, findAny, findFirst, reduce
}
