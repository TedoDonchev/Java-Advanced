package com.company.GenericSwapMethodIntegers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> integers = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(sc.nextLine());

            integers.add(input);

        }

        int[] command = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int pos1 = command[0];
        int pos2 = command[1];

        swap(integers, pos1, pos2);

        for (Integer el : integers) {
            System.out.printf("%s: %s%n", el.getClass().getName(), el);
        }

    }

    public static <T> void swap(List<T> list, int firstIndex, int secondIndex) {

        T temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);

    }
}
