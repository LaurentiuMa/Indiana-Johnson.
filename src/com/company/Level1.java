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
public class Level1 extends GameLevel {

    private static final int NUM_TREASURES = 0;
    private Player player;
    private static final BodyImage backgroundLayer3 = new BodyImage("data/JungleAssets/parallax background/plx-3.png",51);
    private static final BodyImage backgroundLayer4 = new BodyImage("data/JungleAssets/parallax background/plx-4.png",51);
    private static final BodyImage backgroundLayer2 = new BodyImage("data/JungleAssets/parallax background/plx-2.png",51);

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        //Background background = new Background(this);

        //platforms
        makePlatform(2.8f,0.5f,-22.8f,-18f,0);
        makePlatform(2.8f,0.5f,-13f,-15f,0);
        makePlatform(2.8f,0.5f,-2f,-13f,0);
        makePlatform(1.4f,0.5f,-13f,-8f,0);
        makePlatform(2.8f,0.5f,-0.6f,-6f,0);
        makePlatform(1.4f,0.5f,7.7f,-4f,0);
        makePlatform(1.4f,0.5f,13.7f,-2f,0);
        makePlatform(1.4f,0.5f,19.7f,0f,0);
        makePlatform(1.4f,0.5f,25f,5f,0);
        makePlatform(2.8f,0.5f,16f,10f,0);
        makePlatform(1.4f,0.5f,10f,13f,0);
        makePlatform(1.4f,0.5f,0f,13f,0);
        makePlatform(0.7f,0.5f,-5f,14f,0);
        makePlatform(0.7f,0.5f,-15f,14f,0);
        makePlatform(2.8f,0.5f,-22.8f,10f,0);




        Body rock = new Rock(this);
        rock.setPosition(new Vec2(-18.9f, 20f));
        rock.addCollisionListener(new Hit(getPlayer()));

        Body rock2 = new Rock(this);
        rock2.setPosition(new Vec2(-7.5f, 95f));
        ((Rock) rock2).setGravityScale(0.8f);
        rock2.addCollisionListener(new Hit(getPlayer()));

        Body rock3 = new Rock(this);
        rock3.setPosition(new Vec2(-7.5f, 95f));
        ((Rock) rock3).setGravityScale(0.2f);
        rock3.addCollisionListener(new Hit(getPlayer()));

        for (int i = 0; i < 4;i++){
            Body randomRock = new PushableRock(this);
            randomRock.setPosition(new Vec2(ThreadLocalRandom.current().nextInt(-25,25),ThreadLocalRandom.current().nextInt(25,50)));
            randomRock.removeAllImages();
            randomRock.addImage(new BodyImage("data/easyRock.png",2.5f));

        }

        //creates the treasure on the map
        Body treasure = new Treasure(this);
        treasure.setPosition(new Vec2(-23f, 10.5f));
        ((Treasure) treasure).setGravityScale(100);
        treasure.addCollisionListener(new Pickup(getPlayer()));

        //Background is made up of multiple layers, reason for which there are multiple shapes,
        BoxShape backgroundShape = new BoxShape(0.1f,0.1f);
        Body background = new StaticBody(this,backgroundShape);
        background.setPosition(new Vec2(0,-6f));
        background.addImage(backgroundLayer3);

        BoxShape backgroundShape4 = new BoxShape(0.1f,0.1f);
        Body background4 = new StaticBody(this,backgroundShape4);
        background4.setPosition(new Vec2(0,-6f));
        background4.addImage(backgroundLayer4);

        BoxShape backgroundShape2 = new BoxShape(0.1f,0.1f);
        Body background2 = new StaticBody(this,backgroundShape2);
        background2.setPosition(new Vec2(0,-6f));
        background2.addImage(backgroundLayer2);


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
        return new Vec2(-22f,-18f);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-24, -16.3f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCount() == NUM_TREASURES;
    }
}
