package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        Function<int[], Integer> getFirstEl = arr -> arr[0];

        int min = getFirstEl.apply(nums);
        System.out.println(min);
    }
}
