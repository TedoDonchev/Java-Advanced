package com.company.SetsAndMaps;

import java.util.*;

public class _04_CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<Character, Integer> letterOccurences = new TreeMap<>();

        String text = sc.nextLine();

        char[] letterArray = text.toCharArray();

        for (int i = 0; i < letterArray.length; i++) {

            if (!letterOccurences.containsKey(letterArray[i])) {
                letterOccurences.put(letterArray[i], 0);
            }

            letterOccurences.put(letterArray[i], letterOccurences.get(letterArray[i])+1);
        }

        for (Map.Entry<Character, Integer> entry : letterOccurences.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }

    }
}
