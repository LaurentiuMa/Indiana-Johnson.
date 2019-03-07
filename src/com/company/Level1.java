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

    private static final int NUM_TREASURES = 1;
    private Player player;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

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

        Rock rock = new Rock(this);
        rock.setPosition(new Vec2(-18.9f, 20f));
        rock.addCollisionListener(new Hit(getPlayer()));

        Rock rock2 = new Rock(this);
        rock2.setPosition(new Vec2(-7.5f, 95f));
        rock2.setGravityScale(0.8f);
        rock2.addCollisionListener(new Hit(getPlayer()));

        Rock rock3 = new Rock(this);
        rock3.setPosition(new Vec2(-7.5f, 95f));
        rock3.setGravityScale(0.2f);
        rock3.addCollisionListener(new Hit(getPlayer()));

        for (int i = 0; i < 4;i++){
            Body randomRock = new PushableRock(this);
            randomRock.setPosition(new Vec2(ThreadLocalRandom.current().nextInt(-25,25),ThreadLocalRandom.current().nextInt(25,50)));
            randomRock.removeAllImages();
            randomRock.addImage(new BodyImage("data/easyRock.png",2.5f));

        }

        //creates the treasure on the map
        Treasure treasure = new Treasure(this);
        treasure.setPosition(new Vec2(-23f, 10.5f));
        treasure.setGravityScale(100);
        treasure.addCollisionListener(new Pickup(getPlayer()));

        Treasure treasure2 = new Treasure(this);
        treasure2.setPosition(new Vec2(-23f, 0f));
        treasure2.setGravityScale(100);
        treasure2.addCollisionListener(new Pickup(getPlayer()));

        background(1);


    }

    @SuppressWarnings("Duplicates")
    //method makes it easier to create platforms whenever I need them


    @Override
    public Vec2 startPosition() {
        return new Vec2(-22f,-18f);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-24.2f, -16.3f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getTreasuresFound() == NUM_TREASURES;
    }

    @Override
    public Color getBackgroundColor(){return Color.getHSBColor(80,68,40);}
}
