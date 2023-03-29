package com.mygdx.game.oopGame.InfantryClass;

import java.util.ArrayList;
import java.util.Random;

import com.mygdx.game.oopGame.BaseHero;
import com.mygdx.game.oopGame.Positions;

/**
 * Это класс пехота
 */

public abstract class InfantryClass extends BaseHero {

    protected int maxDamage;


    public InfantryClass(String name, int hp, int speed,int damage, int maxDamage, int protection, int x, int y) {
        super(name, hp, speed, maxDamage, protection, x, y);
        
      
    }

    public boolean checkCells (Positions newPosition, ArrayList<BaseHero> friends ){
        for (BaseHero friend : friends) {
            if(newPosition.isEquals(friend.getPosition())){
                return false;
            }
        }
        if(newPosition.getX() < 0 || newPosition.getX() > 9 || newPosition.getY() < 0 || newPosition.getY() > 9) {
            return false;
        }
        return true;
    }
    
    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> friends){
        BaseHero target = enemies.get(0);
        if(this.hp > 0){
            Positions temp = new Positions(this.position.getX(), this.position.getY());
            int dX = target.getPosition().getX() - this.position.getX();
            int dY = target.getPosition().getY() - this.position.getY();
            
            if (Math.abs(dX) > Math.abs(dY)) {
                // движение по горизонтали
                if (dX > 0) {
                    temp.setX(temp.getX() + 1);
                    if (checkCells(temp, friends)) {
                        this.position.setX(this.position.getX() + 1);
                    }
                } else if (dX < 0) {
                    temp.setX(temp.getX() - 1);
                    if (checkCells(temp, friends)) {
                        this.position.setX(this.position.getX() - 1);
                    }
                }
            } else {
                // движение по вертикали
                if (dY > 0) {
                    temp.setY(temp.getY() + 1);
                    if (checkCells(temp, friends)) {
                        this.position.setY(this.position.getY() + 1);
                    }
                } else if (dY < 0) {
                    temp.setY(temp.getY() - 1);
                    if (checkCells(temp, friends)) {
                        this.position.setY(this.position.getY() - 1);
                    }
                }
            }
            this.attack(target, this.damage, this.maxDamage);
        } 
    }

    @Override
    public void attack(BaseHero target, int damage, int maxDamage) {
        int causedDamage;
        
        if(Math.abs(this.position.getX() - target.getPosition().getX()) == 1 && (this.position.getY() - target.getPosition().getY() == 0)){
            causedDamage = damage;
        }else if(Math.abs(this.position.getY() - target.getPosition().getY()) == 1 && (this.position.getX() - target.getPosition().getX() == 0)){
            causedDamage = damage;
        }
        else {
            switch (new Random().nextInt(4)){
                case 0:
                    causedDamage = maxDamage;
                    break;
                default:
                    causedDamage = damage;
                    break;
            }
        }
        target.getDamage(causedDamage);

    }
}