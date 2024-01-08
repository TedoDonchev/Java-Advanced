package com.company.MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();
        int rotationAngle = Integer.parseInt(command.substring(7, command.length()-1));
        //rotationAngle %= 90; // 1->90 ,2-> 180 ,3->270 ,4->360

        while(rotationAngle > 360) {
            rotationAngle -= 360;

        }

        int numberOfRotations = rotationAngle / 90;


        List<String> temp = new ArrayList<>();
        int longestEl = 0;

        while (true) {
            String input = sc.nextLine();
            if (input.equals("END")) {
                break;
            }

            int currLength = input.length();
            if (currLength > longestEl) {
                longestEl = currLength;
            }

            temp.add(input);
        }

        char[][] matrix = new char[temp.size()][longestEl];
        populateMatrix(matrix, temp);


        for (int i = 0; i < numberOfRotations; i++) {
            matrix = rotateMatrix(matrix);
            if (i == numberOfRotations-1) {
                printMatrix(matrix);
            }
        }

    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char c : row) {
                if (c == '\u0000') {
                    c = ' ';
                }
                System.out.printf("%c", c);
            }
            System.out.println();
        }
    }


    private static char[][] rotateMatrix(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        char[][] rotatedMatrix = new char[cols][rows];

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                rotatedMatrix[col][row] = matrix[row][col];
            }

        }

        reverseColumns(rotatedMatrix);

        return rotatedMatrix;
    }


    private static void reverseColumns(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length/2; col++) {
                char temp = matrix[row][col];
                matrix[row][col] = matrix[row][matrix[row].length-1-col];
                matrix[row][matrix[row].length-1-col] = temp;
                System.out.println();
            }

        }


    }





    private static void populateMatrix(char[][] matrix, List<String> temp) {

        for (int i = 0; i < temp.size(); i++) {
            String currentWord = temp.get(i);
            char[] charArr = currentWord.toCharArray();

            for (int j = 0; j < charArr.length; j++) {
                matrix[i][j] = charArr[j];
            }
        }
    }
}
