package com.company.MultidimensionalArrays;

public class Player {

    int HP;
    boolean debuff;

    public Player(int HP, boolean debuff) {
        this.HP = HP;
        this.debuff = debuff;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public boolean isDebuff() {
        return debuff;
    }

    public void setDebuff(boolean debuff) {
        this.debuff = debuff;
    }
}
