package com.company;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Level 1 of the game
 */
public class Level2 extends GameLevel {

    private static final int NUM_TREASURES = 1;
    private Player player;

    private static final BodyImage backgroundLayer3 = new BodyImage("data/JungleAssets/parallax background/plx-3.png",51);
    private static final BodyImage backgroundLayer4 = new BodyImage("data/JungleAssets/parallax background/plx-4.png",51);

    public Level2(){

    };

    /**
     * Populate the world.
     */
    @SuppressWarnings("Duplicates")
    @Override
    public void populate(Game game) {
        super.populate(game);

        //Background background = new Background(this);

        //platforms
        makePlatform(2.8f,0.5f,22.8f,-18f,0);
        makePlatform(1.4f,0.5f,13f,-15f,0);
        makePlatform(1.4f,0.5f,2f,-13f,0);
        makePlatform(0.7f,0.5f,11f,-8f,0);
        makePlatform(2.8f,0.5f,0.6f,-6f,0);
        makePlatform(0.7f,0.5f,-7.7f,-4f,0);
        makePlatform(0.7f,0.5f,-13.7f,-2f,0);
        makePlatform(0.7f,0.5f,-19.7f,0f,0);
        makePlatform(0.7f,0.5f,-25f,5f,0);
        makePlatform(3.3f,0.5f,-16f,10f,0);
        makePlatform(0.7f,0.5f,-10f,13f,0);
        makePlatform(0.7f,0.5f,0f,13f,0);
        makePlatform(0.7f,0.5f,5f,14f,0);
        makePlatform(0.7f,0.5f,15f,14f,0);
        makePlatform(1.4f,0.5f,22.8f,10f,0);
//fix this


        BoxShape sensor2Shape = new BoxShape(0.1f,0.1f);
        Body sensor2 = new StaticBody(this,sensor2Shape);
        sensor2.setPosition(new Vec2(-2f,-5f));

        Slime slime1 = new Slime(this);
        slime1.setPosition(new Vec2(0f,-5f));
        slime1.setGravityScale(0);
        slime1.setLinearVelocity(new Vec2(2,0));

        Sensor sensor1 = new Sensor(new StaticBody(this),new BoxShape(0.1f,0.1f));
        sensor1.addSensorListener(new TurnEnemy(slime1));

        Body slime2 = new Slime(this);
        slime2.setPosition(new Vec2(-19f,11f));

        BoxShape backgroundShape4 = new BoxShape(0.1f,0.1f);
        Body background4 = new StaticBody(this,backgroundShape4);
        background4.setPosition(new Vec2(0,-6));
        background4.addImage(backgroundLayer4);


        BoxShape backgroundShape = new BoxShape(0.1f,0.1f);
        Body background = new StaticBody(this,backgroundShape);
        background.setPosition(new Vec2(0,-6));
        background.addImage(backgroundLayer3);


        game.getView().setBackground(Color.getHSBColor(80,68,40));


        //creates the treasure on the map
        Body treasure = new Treasure(this);
        treasure.setPosition(new Vec2(22f, -17f));
        ((Treasure) treasure).setGravityScale(100);
        treasure.addCollisionListener(new Pickup(getPlayer()));


    }

    @SuppressWarnings("Duplicates")
    //method makes it easier to create platforms whenever I need them
    public void makePlatform(float width,float height,float x,float y, float angle){
        Shape platformShape = new BoxShape(width,height);
        Body platform = new StaticBody(this,platformShape);
        platform.setPosition(new Vec2(x,y));
        platform.setAngleDegrees(angle);
        if (width > 1.5f){
            platform.removeAllImages();
            platform.addImage(new BodyImage("data/JungleAssets/platform.png",0.9f));
        }else if (width <1.5f && width > 1f){
            platform.removeAllImages();
            platform.addImage(new BodyImage("data/JungleAssets/halfPlatform.png",0.9f));
        }else{
            platform.removeAllImages();
            platform.addImage(new BodyImage("data/JungleAssets/smallPlatform.png",0.8f));
        }
    }


    @Override
    public Vec2 startPosition() {
        return new Vec2(22f,-18f);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(27, 50f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCount() == NUM_TREASURES;
    }
}
