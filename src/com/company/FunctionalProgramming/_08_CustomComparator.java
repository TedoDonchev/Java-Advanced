package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _08_CustomComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<Integer, Integer> comparator = x -> Math.abs(x) % 2;

        List<Integer> sorted = nums.stream()
                                    .sorted()
                                    .sorted(Comparator.comparingInt(comparator::apply))
                                    .collect(Collectors.toList());

        sorted.forEach(n -> System.out.printf("%d ", n));
    }
}
