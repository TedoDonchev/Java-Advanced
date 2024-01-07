package com.company.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = input[0];
        int cols = input[1];
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] inputRow = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 0; j < cols; j++) {
                matrix[i][j] = inputRow[j];
            }
        }

        while(true){

            String[] command = sc.nextLine().split(" ");
            if (command[0].equals("END")) {
                break;
            }
            if (!command[0].equals("swap")) {
                System.out.println("Invalid input!");
                continue;
            }

            int row1 = Integer.parseInt(command[1]);
            int col1 = Integer.parseInt(command[2]);
            int row2 = Integer.parseInt(command[3]);
            int col2 = Integer.parseInt(command[4]);

            boolean validInput = true;

            validInput =  checkValidity(matrix, row1, col1, row2, col2);

            if (validInput) {
                int temp = matrix[row1][col1];
                matrix[row1][col1] =  matrix[row2][col2];
                matrix[row2][col2] = temp;

                printMatrix(matrix);
            }

        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.printf("%d ", num);
            }
            System.out.println();
        }
    }


    private static boolean checkValidity(int[][] matrix, int row1, int col1, int row2, int col2) {
        boolean isValid = true;
        try {
            int element1 = matrix[row1][col1];
            int element2 = matrix[row2][col2];

        } catch (IndexOutOfBoundsException e) {
            isValid = false;
            System.out.println("Invalid input!");
        }
        return isValid;
    }
}
