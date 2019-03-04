package com.company;

import city.cs.engine.Body;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

public class Pickup implements CollisionListener {

        private Player player;


        public Pickup(Player player){
            this.player = player;
        }


        //whenever there is a collision with a player object, the item disappears and the player's treasure count is incremented
        @Override
        public void collide(CollisionEvent e) {
            if (e.getOtherBody() == player) {
                player.incrementTreasuresFound();
                e.getReportingBody().destroy();
            }
        }

    }
