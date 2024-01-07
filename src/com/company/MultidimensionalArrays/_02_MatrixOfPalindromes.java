package com.company.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = input[0];
        int cols = input[1];

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                StringBuilder str = new StringBuilder();
                char firstLetter = (char) (97+i);
                char secondLetter = (char) (97+i+j);
                str.append(firstLetter).append(secondLetter).append(firstLetter);
                matrix[i][j] = str.toString();
                System.out.printf("%s ",matrix[i][j]);
            }
            System.out.println();
        }
    }
}
