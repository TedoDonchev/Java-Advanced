package com.company.DefiningClasses._03_SpeedRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SpeedRacing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelPer1km = Double.parseDouble(input[2]);

            Car car = new Car(model, fuelAmount, fuelPer1km);
            cars.add(car);
        }

        String[] command = sc.nextLine().split("\\s+");

        while (!command[0].equals("End")) {

            String carName = command[1];
            double kmToTravel = Double.parseDouble(command[2]);

            List<Car> filtered = cars.stream()
                    .filter(c -> c.getModel().equals(carName))
                    .collect(Collectors.toList());

            Car currCar = filtered.get(0);

            double fuelUsed = kmToTravel * currCar.getFuelPer1km();

            if (fuelUsed > currCar.getFuelAmount()) {
                System.out.println("Insufficient fuel for the drive");
            } else {
                currCar.setFuelAmount(currCar.getFuelAmount() - fuelUsed);
                currCar.setDistanceTravelled(currCar.getDistanceTravelled() + kmToTravel);
            }

            command = sc.nextLine().split("\\s+");
        }


        cars.forEach(c -> System.out.println(c.toString()));
    }

}
