package com.company;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Rock extends DynamicBody {

    private static final BodyImage image = new BodyImage("data/rock.png", 2.5f);
    private static final Shape collidingShape = new BoxShape(1f, 1f);

    public Rock(World w){
        super(w, collidingShape);
        addImage(image);


//        Body box = new DynamicBody(w, boxShape);
//        box.setPosition(new Vec2(-18.9f, 20f));
//        ((DynamicBody) box).setGravityScale(6);
//        box.addImage(image);

//        Shape horizontalBoxShape = new BoxShape(1f,1f);
//        Body horizontalBox = new DynamicBody(w,boxShape);
//        horizontalBox.setPosition(new Vec2(6,6));
//        ((DynamicBody) horizontalBox).setGravityScale(0);
//        ((DynamicBody) horizontalBox).setLinearVelocity(new Vec2(-1,0));




    }



}
