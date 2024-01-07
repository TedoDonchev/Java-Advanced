package com.company.MultidimensionalArrays;

import java.util.Scanner;

public class _01_FillTheMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String method = input[1];

        int[][] matrix = new int[size][size];
        int nextNum = 1;

        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                nextNum = fillFromTop(matrix, col, nextNum);
            } else {
                if (method.equals("A")) {
                    nextNum = fillFromTop(matrix, col, nextNum);
                } else if (method.equals("B")) {
                    nextNum = fillFromBottom(matrix, col, nextNum);
                }

            }
        }

        for (int[] row : matrix) {
            for (int num : row) {
                System.out.printf("%d ", num);
            }
            System.out.println();
        }
    }

    private static int fillFromBottom(int[][] matrix, int col, int nextNum) {
        for (int row = matrix.length - 1; row >= 0; row--) {
            matrix[row][col] = nextNum;
            nextNum += 1;
        }

        return nextNum;

    }

    private static int fillFromTop(int[][] matrix, int col, int nextNum) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = nextNum;
            nextNum += 1;
        }

        return nextNum;

    }



}
