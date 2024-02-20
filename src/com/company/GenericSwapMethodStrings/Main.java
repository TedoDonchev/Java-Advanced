package com.company.GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> strings = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();

            strings.add(input);

        }

        int[] command = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int pos1 = command[0];
        int pos2 = command[1];

        swap(strings, pos1, pos2);

        for (String str : strings) {
            System.out.printf("%s: %s%n", str.getClass().getName(), str);
        }

    }

    public static <T> void swap(List<T> list, int firstIndex, int secondIndex) {

        T temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);

    }

}
