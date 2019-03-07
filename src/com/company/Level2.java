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

    private static final int NUM_TREASURES = 3;
    private Player player;

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
        makePlatform(2.8f,0.5f,-22.5f,15f,0);

        //creates the treasure on the map
        Treasure treasure = new Treasure(this);
        treasure.setPosition(new Vec2(0f, 14f));
        treasure.setGravityScale(100);
        treasure.addCollisionListener(new Pickup(getPlayer()));

        Treasure treasure2 = new Treasure(this);
        treasure2.setPosition(new Vec2(23f, 11f));
        treasure2.setGravityScale(100);
        treasure2.addCollisionListener(new Pickup(getPlayer()));


        BoxShape sensor2Shape = new BoxShape(0.1f,0.1f);
        Body sensor2 = new StaticBody(this,sensor2Shape);
        sensor2.setPosition(new Vec2(-2f,-5f));

        Slime slime1 = new Slime(this);
        slime1.setPosition(new Vec2(0f,-5f));
        slime1.setGravityScale(0);
        slime1.setLinearVelocity(new Vec2(0,0));
        slime1.addCollisionListener(new PushAway(getPlayer()));

        Sensor sensor1 = new Sensor(new StaticBody(this),new BoxShape(0.1f,0.1f));
        sensor1.addSensorListener(new TurnEnemy(slime1));

        Body slime2 = new Slime(this);
        slime2.setPosition(new Vec2(-19f,11f));
        slime2.addCollisionListener(new PushAway(getPlayer()));

        game.getView().setBackground(Color.getHSBColor(80,68,40));

        Shape endGameCollisionShape = new BoxShape(800,5);
        Body endGameCollision = new StaticBody(this,endGameCollisionShape);
        endGameCollision.setPosition(new Vec2(0f,-35f));

        background(2);

    }


    @Override
    public Vec2 startPosition() {
        return new Vec2(22f,-18f);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-24, 16.75f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getTreasuresFound() == NUM_TREASURES;
    }
    @Override
    public Color getBackgroundColor(){return Color.getHSBColor(84,38,120);}
}
