package com.company.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _03_MaximumElement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> trackerStack = new ArrayDeque<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            int command = Integer.parseInt(line[0]);

            if (command == 1) {
                int numToAdd = Integer.parseInt(line[1]);

                if (stack.isEmpty() && trackerStack.isEmpty()) {
                    stack.push(numToAdd);
                    trackerStack.push(numToAdd);
                } else {
                    stack.push(numToAdd);
                    if (numToAdd > trackerStack.peek()) {
                        trackerStack.push(numToAdd);
                    } else {
                        trackerStack.push(trackerStack.peek());
                    }
                }


            } else if (command == 2) {
                stack.pop();
                trackerStack.pop();
            } else if (command == 3) {
                printMaxElement(trackerStack);
            }
        }
    }

    private static void printMaxElement(ArrayDeque<Integer> stack) {
        System.out.println(stack.peek());
    }
}
