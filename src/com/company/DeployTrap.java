package com.company;

import city.cs.engine.Body;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class DeployTrap implements CollisionListener{

    private DynamicBody trapBottom;
    private TrapButton button;

    public DeployTrap(DynamicBody trapBottom){
        this.trapBottom = trapBottom;
    }

    @Override
    public void collide(CollisionEvent e) {
        if(e.getOtherBody() instanceof Player){
            trapBottom.setLinearVelocity(new Vec2(20,0));
        }
    }
}
