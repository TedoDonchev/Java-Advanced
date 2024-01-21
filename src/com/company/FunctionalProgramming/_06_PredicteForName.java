package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _06_PredicteForName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int allowedLength = Integer.parseInt(sc.nextLine());

        List<String> names = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Predicate<String> checkLength = s -> s.length() <= allowedLength;

        List<String> filteredNames = names.stream()
                .filter(checkLength)
                .collect(Collectors.toList());

        filteredNames.stream().forEach(System.out::println);
    }
}
