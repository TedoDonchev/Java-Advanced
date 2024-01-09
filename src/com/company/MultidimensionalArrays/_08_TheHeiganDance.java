package com.company.MultidimensionalArrays;

import java.util.Scanner;

public class _08_TheHeiganDance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] room  = new String[15][15];

        populateMatrixWithSpaces(room);

        room[7][7] = "player"; //starting position of player
        int[] playerPosition = {7, 7};

        int playerHP = 18_500;
        double heiganHP = 3_000_000;

        Player player = new Player(playerHP, false);

        double damageToHeiganEachTurn = Integer.parseInt(sc.nextLine());

        String lastSpell = null;

        while (player.getHP() > 0 || heiganHP > 0) {
            if (player.getHP() == 0 || heiganHP == 0) {
                break;
            }

            heiganHP -= damageToHeiganEachTurn;
            if (heiganHP <= 0) {
                break;
            }

            if (player.isDebuff()) {
                player.setHP(player.getHP()-3500);
                player.setDebuff(false);
            }

            String[] command = sc.nextLine().split(" ");
            String spell = command[0];
            int affectedRow = Integer.parseInt(command[1]);
            int affectedCol = Integer.parseInt(command[2]);

            boolean isHit = isPlayerInDamagedArea(room, affectedRow, affectedCol);

            if (isHit) {

                boolean didPlayerMove = false;

                for (int i = 1; i <= 4; i++) {
                    //1-> up, 2->right, 3->down, 4->left
                    String[] directions = {"up", "right", "down", "left"};
                    String direction = directions[i-1];
                    playerPosition = returnPlayerPosition(room);

                    didPlayerMove = movePlayer(room, playerPosition, direction);

                    if (didPlayerMove) {
                        break;
                    }
                }

                if (!didPlayerMove) {
                    dealDamageToPlayer(player, spell);
                }
            }

            lastSpell = spell;
            clearDamageFromRoom(room);
        }

        if (heiganHP <= 0) {
            System.out.println("Heigan: Defeated!");
        } else{
            System.out.printf("Heigan %.2f%n", heiganHP);
        }

        if (player.getHP() <= 0) {
            System.out.printf("Player: killed by %s%n", lastSpell);
        } else {
            System.out.printf("Player: %d%n", player.getHP());
        }

        int[] finalCoordinates = returnPlayerPosition(room);

        System.out.printf("Final position: %d, %d%n", finalCoordinates[0], finalCoordinates[1]);

    }

    private static void populateMatrixWithSpaces(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = " ";
            }
        }
    }

    private static void dealDamageToPlayer(Player player, String spell) {
        if (spell.equals("Cloud")) {
            player.setHP(player.getHP()-3500);
            player.debuff = true;
        } else if (spell.equals("Eruption")) {
            player.setHP(player.getHP()-6000);
        }
    }

    private static boolean movePlayer(String[][] matrix, int[] currentPosition, String direction) {
        int currRow = currentPosition[0];
        int currCol = currentPosition[1];
        int newRow = currRow;
        int newCol = currCol;

        switch (direction) {
            case "up": newRow = currRow - 1;
                break;
            case "right": newCol = currCol + 1;
                break;
            case "down": newRow = currRow + 1;
                break;
            case "left": newCol = currCol - 1;
                break;
        }

        try {
            String newPosition = matrix[newRow][newCol];
        } catch (IndexOutOfBoundsException e) {
            return false;
        }

        if (matrix[newRow][newCol].equals("damage")) {
            return false;
        }

        matrix[newRow][newCol] = "player";
        matrix[currRow][currRow] = "damage";
        return true;
    }

    private static boolean isPlayerInDamagedArea(String[][] matrix, int row, int col) {
        int startRow = row-1;
        int endRow = row+1;
        int startCol = col-1;
        int endCol = col+1;
        if (row == 0) startRow = row;
        if (row == 14) endRow = row;
        if (col == 0) startCol = col;
        if (col == 14) endCol = col;

        boolean isHit = false;

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (matrix[i][j].equals("player")) { //matrix[i][j] = "player"
                    isHit = true;
                } else {
                    matrix[i][j] = "damage";
                }
            }

        }
        return isHit;
    }

    private static void clearDamageFromRoom(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("damage")) {
                    matrix[i][j] = " ";
                }
            }

        }
    }

    private static int[] returnPlayerPosition(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("player")) {
                    return new int[]{i, j};
                }
            }

        }
        return new int[]{0, 0};
    }
}
