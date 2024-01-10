package com.company.SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class _01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashSet<String> usernames = new LinkedHashSet<>();

        int numberOfInputs = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numberOfInputs; i++) {
            String username = sc.nextLine();

            usernames.add(username);

        }

        for (String username : usernames) {
            System.out.println(username);
        }

    }
}
