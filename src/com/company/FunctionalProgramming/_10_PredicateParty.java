package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10_PredicateParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> people = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Predicate<String> check;

        String command = sc.nextLine();

        while (!command.equals("Party!")) {
            String[] tokens = command.split("\\s+");

            if (command.contains("StartsWith")) {
                check = s -> s.startsWith(tokens[2]);
            } else if (command.contains("EndsWith")) {
                check = s -> s.endsWith(tokens[2]);
            } else {
                check = s -> s.length() == Integer.parseInt(tokens[2]);
            }

            if (command.contains("Remove")) {
                people.removeIf(check);
            } else if (command.contains("Double")) {
                List<String> guestsToDouble = people.stream()
                        .filter(check)
                        .collect(Collectors.toList());

                people.addAll(guestsToDouble);
            }

            command = sc.nextLine();
        }

        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {

            List<String> orderedPeople = people.stream().sorted(String::compareTo).collect(Collectors.toList());

            System.out.printf("%s are going to the party!",String.join(", ", orderedPeople));
        }

    }
}
