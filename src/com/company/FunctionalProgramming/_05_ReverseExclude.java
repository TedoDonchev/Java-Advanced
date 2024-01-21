package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_ReverseExclude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(sc.nextLine());

        List<Integer> filteredNums = nums.stream()
                .filter(x -> x % n != 0)
                .collect(Collectors.toList());

        Collections.reverse(filteredNums);

        filteredNums.stream().forEach(x -> System.out.printf("%d ",x));


    }
}
