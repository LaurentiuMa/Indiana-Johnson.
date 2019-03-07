package com.company;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class TrapButton extends StaticBody {

    private static final Shape endGameCollisionShape = new BoxShape(1,1);

    public TrapButton(World w) {
        super(w,endGameCollisionShape);
        setPosition(new Vec2(0f,-35f));
    }
}
