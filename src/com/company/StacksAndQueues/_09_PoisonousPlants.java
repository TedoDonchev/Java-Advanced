package com.company.StacksAndQueues;

import java.util.*;
import java.util.stream.Collectors;

public class _09_PoisonousPlants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int numOfPlants = Integer.parseInt(sc.nextLine());

        List<Integer> plants = Arrays
                .stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int daysCounter = 0;
        boolean plantDeath;

        do {
            plantDeath = iterateStack(plants, stack);
            if (plantDeath) {
                daysCounter += 1;
            }
        } while (plantDeath);

        System.out.println(daysCounter);
    }

    private static boolean iterateStack(List<Integer> plants, ArrayDeque<Integer> stack) {
        boolean didDie = false;
        stack.clear();

        int lastPlant = 0;

        for (int i = 0; i < plants.size(); i++) {
            int plant = plants.get(i);
            if (stack.isEmpty()) {
                stack.push(plant);
                lastPlant = stack.peek();
                continue;
            }

            if (plant > lastPlant) {
                didDie = true;
                plants.remove(plants.indexOf(plant));
                i-=1;
            } else {
                stack.push(plant);
            }

            lastPlant = plant;
        }

        return didDie;
    }
}
