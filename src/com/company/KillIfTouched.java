package com.company;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class KillIfTouched implements CollisionListener {

    private Player player;

    public KillIfTouched(Player player){
        this.player = player;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == player) {
            player.kill();
            System.out.println("KILLED");
        }else{
            e.getOtherBody().destroy();
        }
    }


}
