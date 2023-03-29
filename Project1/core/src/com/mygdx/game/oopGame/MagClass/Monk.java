package com.mygdx.game.oopGame.MagClass;

/**
 * Это класс Монах
 */


public class Monk extends MagClass {

    public Monk(String name, int x, int y) {
        super(name, 30,5, 1, -4,7, x,y);
    }


    @Override
    public String getName() {
        return "Монах";
    }
    
}
