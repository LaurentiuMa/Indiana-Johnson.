package com.company;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class Hit implements CollisionListener {

    private Player player;

    public Hit(Player player){
        this.player = player;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == player) {
            player.reduceHp(25);
            System.out.println("25 Damage dealt");
            e.getReportingBody().destroy();
        }
    }

}
