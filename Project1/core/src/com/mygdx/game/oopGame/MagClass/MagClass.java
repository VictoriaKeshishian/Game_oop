package com.mygdx.game.oopGame.MagClass;

import java.util.ArrayList;

import com.mygdx.game.oopGame.BaseHero;

/**
 * Это класс магов
 */

public abstract class MagClass extends BaseHero {

    protected int mana;

    public MagClass(String name, int hp,int speed, int mana,int damage,int protection, int x, int y) {
        super(name, hp, speed, damage, protection, x, y);
        this.mana = mana;
    
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> friends) {
        for (BaseHero hero : friends) {
            if (hero.hp < hero.maxHp) { // Если у героя не полные хитпойнты
                for (BaseHero enemy : enemies) {
                    enemy.attack(hero, damage, damage);
                    break;
                }
            }
        }
    }
 
    
}
