package com.company.DefiningClasses._06_PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class PokemonTrainer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Trainer> trainers = new ArrayList<>();


        String command = sc.nextLine();

        while (!command.equals("Tournament")) {
            String[] tokens = command.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer trainer = new Trainer(trainerName, new ArrayList<>());
            trainer.addPokemon(pokemon);

            boolean trainerExists = containsTrainer(trainers, trainerName);

            if (!trainerExists) {
                //new Trainer
                trainers.add(trainer);
            } else {
                List<Trainer> filtered = trainers.stream()
                                            .filter(t -> t.getName().equals(trainerName))
                                            .collect(Collectors.toList());

                Trainer currTrainer = filtered.get(0);

                currTrainer.addPokemon(pokemon);

            }

            command = sc.nextLine();
        }


        command = sc.nextLine();

        while (!command.equals("End")) {
            String currElement = command;

            trainers.forEach(t -> {
                List<Pokemon> pokemons = t.getPokemons();

                boolean hasElement = containsElement(pokemons, currElement);

                if (hasElement) {
                    t.setBadges(t.getBadges() + 1);
                } else {
                    pokemons.forEach(p -> p.setHealth(p.getHealth() - 10));
                    List<Pokemon> filteredPokemons = pokemons.stream().filter(p -> p.getHealth() > 0).collect(Collectors.toList());
                    t.setPokemons(filteredPokemons);
                }
            });

            command = sc.nextLine();
        }


        List<Trainer> sortedTrainers = trainers.stream().sorted((a, b) -> b.getBadges() - a.getBadges()).collect(Collectors.toList());

        sortedTrainers.forEach(t -> System.out.println(t.toString()));

    }

    public static boolean containsTrainer(final List<Trainer> list, String name){
        return list.stream().anyMatch(o -> o.getName().equals(name));
    }

    public static boolean containsElement(final List<Pokemon> list, String element){
        return list.stream().anyMatch(o -> o.getElement().equals(element));
    }
}
