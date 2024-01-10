package com.company.SetsAndMaps;

import java.util.HashMap;
import java.util.Scanner;

public class _05_Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, String> phonebook = new HashMap<>();

        String command = sc.nextLine();
        while (!command.equals("search")) {
            String[] tokens = command.split("-");
            String name = tokens[0];
            String telNr = tokens[1];

            phonebook.put(name, telNr);

            command = sc.nextLine();
        }


        command = sc.nextLine();
        while (!command.equals("stop")) {
            String name = command;
            String output = "";
            if (!phonebook.containsKey(name)) {
                output = String.format("Contact %s does not exist.%n", name);
            } else {
                output = String.format("%s -> %s%n", name, phonebook.get(name));
            }

            System.out.print(output);

            command = sc.nextLine();
        }

    }
}
