package com.company.CustomList;

import java.util.Scanner;

public class Main {

    public static <T> void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CustomList<T> list = new CustomList<>();

        String[] command = sc.nextLine().split("\\s+");

        while (!command[0].equals("END")) {

            if (command[0].equals("Add")) {
                T element = (T) command[1];
                list.add(element);
            } else if (command[0].equals("Remove")) {
                int index = Integer.parseInt(command[1]);
                list.remove(index);
            } else if (command[0].equals("Contains")) {
                T element = (T) command[1];
                System.out.println(list.contains(element));
            } else if (command[0].equals("Swap")) {
                int indx1 = Integer.parseInt(command[1]);
                int indx2 = Integer.parseInt(command[2]);
                list.swap(indx1, indx2);
            } else if (command[0].equals("Greater")) {
                T element = (T) command[1];
                System.out.println(list.countGreaterThan(element));
            } else if (command[0].equals("Max")) {
                System.out.println(list.getMax());
            } else if (command[0].equals("Min")) {
                System.out.println(list.getMin());
            } else if (command[0].equals("Print")) {
                list.print();
            }


            command = sc.nextLine().split("\\s+");
        }
    }
}
