package com.company;

import city.cs.engine.*;

public class ZombieBoss extends Walker {

    private int hp;
    private static final Shape zombieShape = new BoxShape(2.5f,4f);
    private BodyImage zombieImage = new BodyImage("data/zombie.gif",7.7f);

    public ZombieBoss(World w) {
        super(w, zombieShape);
        addImage(zombieImage);
        hp = 80;
    }

    public int getHp() {
        return hp;
    }
    public void reduceHp(int amount){
        hp -= amount;
    }
}
