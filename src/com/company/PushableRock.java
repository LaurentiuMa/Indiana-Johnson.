package com.company;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class PushableRock extends DynamicBody {

    private static final BodyImage image = new BodyImage("data/easyRock.png", 2f);
    private static final Shape collidingShape = new PolygonShape(
            -1.15f,0.008f, -0.581f,-0.358f, -0.039f,-0.347f, 0.411f,0.014f, 0.411f,0.357f, -0.147f,0.904f, -0.586f,0.91f, -1.139f,0.369f
    );

    public PushableRock(World w){
        super(w, collidingShape);
        addImage(image);

    }



}
