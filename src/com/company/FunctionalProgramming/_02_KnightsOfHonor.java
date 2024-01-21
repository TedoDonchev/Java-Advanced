package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class _02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = sc.nextLine().split("\\s+");

        Arrays.stream(names).forEach(w -> System.out.println("Sir " + w));
    }
}
