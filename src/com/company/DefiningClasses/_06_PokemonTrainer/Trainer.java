package com.company.DefiningClasses._06_PokemonTrainer;

import java.util.List;

public class Trainer {

    private String name;
    private int badges;
    private List<Pokemon> pokemons;


    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.badges = 0;
        this.pokemons = pokemons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon) {
        this.pokemons.remove(pokemon);
    }

    public boolean equals(Trainer t) {
        return this.getName().equals(t.getName());
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.getName(), this.getBadges(), this.getPokemons().size());
    }
}
