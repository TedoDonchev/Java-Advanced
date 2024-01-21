package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findSmallest =  l -> {
            List<Integer> sortedNums = l.stream().sorted().collect(Collectors.toList());
            return sortedNums.get(0);
        };

        int smallestNum = findSmallest.apply(nums);

        System.out.println(nums.lastIndexOf(smallestNum));

    }

}
