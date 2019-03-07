package com.company;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class EndGameCollision extends StaticBody{

    private static final Shape endGameCollisionShape = new BoxShape(800,5);

    public EndGameCollision(World w) {
        super(w,endGameCollisionShape);
        setPosition(new Vec2(0f,-35f));
    }
}
