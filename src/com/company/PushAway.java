package com.company;

import city.cs.engine.Body;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class PushAway implements CollisionListener{

    private Player player;

    public PushAway(Player player){
        this.player = player;
    }

    @Override
    public void collide(CollisionEvent e) {
        if(e.getOtherBody() == player){
            player.setAngularVelocity(-5f);
            player.setLinearVelocity(new Vec2(-10f,-30f));
            System.out.println("PUSHED");

        }
    }
}
