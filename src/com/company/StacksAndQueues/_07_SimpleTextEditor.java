package com.company.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _07_SimpleTextEditor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque();

        int numOperations = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numOperations; i++) {
            String[] command = sc.nextLine().split(" ");
            int commandType = Integer.parseInt(command[0]);

            if (commandType == 1) {
                if (stack.isEmpty()) {
                    stack.push(command[1]);
                    continue;
                }

                stack.push(stack.peek().concat(command[1]));

            } else if (commandType == 2) {
                String newStr = eraseFromEnd(stack.peek(), Integer.parseInt(command[1]));
                stack.push(newStr);
            } else if (commandType == 3) {
                char ch = returnCharAtIndex(stack.peek(), Integer.parseInt(command[1]));
                System.out.println(ch);
            } else if (commandType == 4) {
                stack.pop();
            }

        }

    }

    private static Character returnCharAtIndex(String str, int index) {
        return str.charAt(index - 1);
    }

    private static String eraseFromEnd(String str, int count) {
        return str.substring(0, str.length() - count);
    }


}
