package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class _01_ConsumerPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = sc.nextLine().split("\\s+");

        Arrays.stream(words).forEach(w -> System.out.println(w));
    }
}
