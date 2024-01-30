package com.company.DefiningClasses._01_OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OpinionPoll {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");

            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);

            people.add(person);

        }

        List<Person> sortedPeople = people.stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());

        sortedPeople.forEach(p -> System.out.printf("%s - %d%n", p.getName(), p.getAge()));


    }
}
