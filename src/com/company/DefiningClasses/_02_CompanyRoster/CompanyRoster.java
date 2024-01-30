package com.company.DefiningClasses._02_CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CompanyRoster {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        int numOfInputs = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numOfInputs; i++) {

            String[] input = sc.nextLine().split("\\s+");

            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];

            boolean element4 = testInput(input, 4);
            boolean element5 = testInput(input, 5);

            Employee employee;

            if (element4 && element5) {
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (element4) {
                if (Character.isDigit(input[4].charAt(0))) {
                    //4h element is digit
                    int age = Integer.parseInt(input[4]);
                    employee = new Employee(name, salary, position, department, age);
                } else {
                    String email = input[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            } else {
                employee = new Employee(name, salary, position, department);
            }

            employees.add(employee);
        }

        List<Employee> sortedEmployees = employees.stream()
                                            .sorted((a,b) -> (int) (b.getSalary() - a.getSalary()))
                                            .collect(Collectors.toList());



        sortedEmployees.forEach(e -> System.out.printf("%s %.2f %s %d%n", e.getName(), e.getSalary(), e.getEmail(), e.getAge()));

    }


    public static boolean testInput(String[] input, int i) {
        try {
            String el = input[i];
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }
}
