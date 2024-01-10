package com.company.SetsAndMaps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class _02_SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] setsSize = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        HashSet<Integer> firstSet = new HashSet<>();
        HashSet<Integer> secondSet = new HashSet<>();
        HashSet<Integer> repeated = new HashSet<>();


        for (int i = 0; i < setsSize[0]; i++) {
            int num = Integer.parseInt(sc.nextLine());
            firstSet.add(num);
        }

        for (int i = 0; i < setsSize[1]; i++) {
            int num = Integer.parseInt(sc.nextLine());
            secondSet.add(num);
        }


        for (Integer num : secondSet) {
            if (firstSet.contains(num)) {
                System.out.printf("%d ", num);
            }

        }

    }
}
