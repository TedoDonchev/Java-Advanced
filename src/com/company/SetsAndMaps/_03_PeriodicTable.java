package com.company.SetsAndMaps;

import java.util.Scanner;
import java.util.TreeSet;

public class _03_PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfInputs = Integer.parseInt(sc.nextLine());
        TreeSet<String> chemicalCompounds = new TreeSet<>();

        for (int i = 0; i < numOfInputs; i++) {
            String[] tokens = sc.nextLine().split(" ");

            for (int j = 0; j < tokens.length; j++) {
                String compound = tokens[j];
                chemicalCompounds.add(compound);

            }
        }

        for (String chemicalCompound : chemicalCompounds) {
            System.out.printf("%s ", chemicalCompound);
        }
    }
}
