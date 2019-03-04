package com.company;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Treasure extends DynamicBody{

    private static final BodyImage imageClosed = new BodyImage("data/rpg-pack/props n decorations/generic-rpg-treasure-closed.png", 1.5f);
//    private static final BodyImage imageOpen = new BodyImage("data/rpg-pack/props n decorations/generic-rpg-trasure-open.png",1.5f);

    private static final Shape collidingShape = new PolygonShape(

            -0.889f,-0.661f, 0.882f,-0.646f, 0.886f,0.736f, -0.886f,0.739f
    );

    public Treasure(World w){
        super(w, collidingShape);
        addImage(imageClosed);
    }


}
