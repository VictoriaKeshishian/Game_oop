package com.mygdx.game.oopGame.InfantryClass;



/**
 * Это класс Копейщик
 */

public class Spearman extends InfantryClass {

    public Spearman(String name, int x, int y) {
        super(name,15,9,10,10,10, x, y);
    }

    @Override
    public String getName() {
        return "Копейщик";
    }
}
