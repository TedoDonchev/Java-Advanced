package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _04_AppliedArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = sc.nextLine();

        Function<Integer, Integer> add = x -> x + 1;
        Function<Integer, Integer> multiply = x -> x * 2;
        Function<Integer, Integer> subtract = x -> x - 1;
        Consumer<Integer> print = x -> System.out.printf("%d ",x);

        while(!command.equals("end")) {

            switch (command) {
                case "add": nums = nums.stream().map(add).collect(Collectors.toList());
                    break;
                case "multiply": nums = nums.stream().map(multiply).collect(Collectors.toList());
                    break;
                case "subtract": nums = nums.stream().map(subtract).collect(Collectors.toList());
                    break;
                case "print": nums.stream().forEach(x -> print.accept(x));
            }



            command = sc.nextLine();
        }
    }
}
