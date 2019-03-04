package com.company;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class TurnEnemy implements SensorListener {

    private Slime slime;

    public TurnEnemy(Slime slime){
        this.slime = slime;
    }

    @Override
    public void beginContact(SensorEvent sensorEvent) {
        if (sensorEvent.getContactBody() == slime) {
            slime.setPosition(new Vec2( -slime.getLinearVelocity().x,0));
            System.out.println("enemy turned");
        }
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
