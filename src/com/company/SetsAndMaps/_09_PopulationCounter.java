package com.company.SetsAndMaps;



import java.util.*;
import java.util.stream.Collectors;

public class _09_PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> countries = new LinkedHashMap<>();


        String inputLine = sc.nextLine();

        while (!inputLine.equals("report")){
            String[] tokens = inputLine.split("\\|");
            String currentCity = tokens[0];
            String country = tokens[1];
            int population = Integer.parseInt(tokens[2]);


            if (!countries.containsKey(country)) {
                countries.put(country, new LinkedHashMap<String, Integer>());
            }

            LinkedHashMap<String, Integer> cities = countries.get(country);

            cities.put(currentCity, population);
            countries.put(country,cities);

            inputLine = sc.nextLine();
        }

        

        List<Map.Entry<String, LinkedHashMap<String, Integer>>> sorted =
                countries.entrySet()
                    .stream()
                    .sorted((a, b) -> Integer.compare(
                        b.getValue().values().stream().mapToInt(l -> l).sum(),
                        a.getValue().values().stream().mapToInt(l -> l).sum())
                    )
                    .collect(Collectors.toList());





        for (Map.Entry<String, LinkedHashMap<String, Integer>> country : sorted) {
            String countryName = country.getKey();
            LinkedHashMap<String, Integer> cities = country.getValue();

            List<Map.Entry<String, Integer>> sortedCities =
                    cities.entrySet()
                            .stream()
                            .sorted((a, b) -> Integer.compare(
                                    b.getValue(),
                                    a.getValue())
                            )
                            .collect(Collectors.toList());

            int sum = cities.values().stream().mapToInt(x -> x).sum();
            System.out.printf("%s (total population: %d)%n", countryName, sum);

            for (Map.Entry<String, Integer> city : sortedCities) {
                System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());
            }

        }
    }
}
