package com.company.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[size][size];

        int primarySum = 0;
        int secondarySum = 0;

        for (int row = 0; row < size; row++) {
            int[] input = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < size; col++) {
                matrix[row][col] = input[col];

                if (row == col) {
                    primarySum += matrix[row][col];
                }
                if (row+col == size - 1) {
                    secondarySum += matrix[row][col];
                }

            }

        }

        System.out.println(Math.abs(primarySum-secondarySum));

    }
}
