package com.mygdx.game.oopGame.InfantryClass;

/**
 * Класс Разбойник
 */

public class Outlaw extends InfantryClass {

    public Outlaw(String name, int x, int y) {
        super(name,10,6,4,3,3, x,y);
    }

    @Override
    public String getName() {
        return "Разбойник";
    }

}


