package com.company.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();


        int[] input = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int elementsToRemove = input[1];
        int checkElement = input[2];

        int[] nums = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int num : nums) {
            queue.offer(num);
        }

        for (int i = 0; i < elementsToRemove; i++) {
            queue.poll();
        }

        checkExistenceOfElement(queue, checkElement);
    }

    private static void checkExistenceOfElement(ArrayDeque<Integer> queue, int checkElement) {
        if (queue.contains(checkElement)) {
            System.out.println(true);
        } else if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            int min = queue.peek();
            for (Integer num : queue) {
                if (num < min) {
                    min = num;
                }
            }

            System.out.println(min);
        }

    }
}
