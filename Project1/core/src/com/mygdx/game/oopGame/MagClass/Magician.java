package com.mygdx.game.oopGame.MagClass;

/**
 * Это класс колдун
 */



public class Magician extends MagClass {

    public Magician(String name, int x, int y) {
        super(name, 30,9, 1,-5,12, x, y);
    }


    @Override
    public String getName() {
        return "Колдун";
    }
    
}
