package com.company.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _02_BasicStackOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] tokens =  Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numberOfElements = tokens[0];
        int elementsToRemove = tokens[1];
        int checkElement = tokens[2];

        int[] nums = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int num : nums) {
            stack.push(num);
        }

        for (int i = 0; i < elementsToRemove; i++) {
            stack.pop();
        }

        checkStack(stack, checkElement);

    }

    private static boolean checkStack(ArrayDeque<Integer> stack, int checkElement) {
        if (stack.contains(checkElement)) {
            System.out.println(true);
            return true;
        }

        if (stack.isEmpty()) {
            System.out.println(0);
            return true;
        }

        System.out.println(getMinElement(stack));
        return true;
    }

    private static int getMinElement(ArrayDeque<Integer> stack) {
        int min = stack.peek();

        for (Integer num : stack) {
            if (min > num) {
                min = num;
            }
        }

        return min;
    }
}
