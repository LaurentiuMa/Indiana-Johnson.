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
public class Level3 extends GameLevel {

    private static final int NUM_TREASURES = 0;
    private Player player;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        makePlatform(2.8f,0.5f,-22.8f,-18f,0);
        makePlatform(2.8f,0.5f,-16.7f,-18f,0);
        makePlatform(2.8f,0.5f,-10.6f,-18f,0);
        makePlatform(2.8f,0.5f,-4.5f,-18f,0);
        makePlatform(2.8f,0.5f,1.6f,-18f,0);
        makePlatform(2.8f,0.5f,7.7f,-18f,0);
        makePlatform(2.8f,0.5f,13.8f,-18f,0);
        makePlatform(2.8f,0.5f,19.9f,-18f,0);
        makePlatform(2.8f,0.5f,26f,-18f,0);
        makePlatform(2.8f,0.5f,22.5f,15f,0);
        makePlatform(2.8f,0.5f,12.5f,8f,45);

        Shape trapBottomShape = new BoxShape(5f,0.2f);
        DynamicBody trapBottom = new DynamicBody(this,trapBottomShape);
        trapBottom.setPosition(new Vec2(-19,-9));
        trapBottom.setGravityScale(0);

        TrapButton button = new TrapButton(this);
        button.addCollisionListener(new DeployTrap(trapBottom));
        button.setPosition(new Vec2(5,0));

        Shape sideShape = new BoxShape(0.5f,5f);
        StaticBody leftSide = new StaticBody(this,sideShape);
        StaticBody rightSide = new StaticBody(this,sideShape);
        rightSide.setPosition(new Vec2(-14.5f,-4));
        leftSide.setPosition(new Vec2(-23.5f,-4));

        ZombieBoss boss = new ZombieBoss(this);
        boss.setPosition(new Vec2(-19,-14));

        for (int i = 0;i < 4; i++){
            Rock rock = new Rock(this);
            rock.setPosition(new Vec2(ThreadLocalRandom.current().nextInt(-22,-17),ThreadLocalRandom.current().nextInt(-4,5)));
            rock.addCollisionListener(new HitZombie(boss));
        }

        for (int i = 0; i < 10;i++){
            Body randomRock = new PushableRock(this);
            randomRock.setPosition(new Vec2(ThreadLocalRandom.current().nextInt(-25,25),ThreadLocalRandom.current().nextInt(25,150)));
            randomRock.removeAllImages();
            randomRock.addImage(new BodyImage("data/easyRock.png",2.5f));

        }

        TrapButton trapButton = new TrapButton(this);
        trapButton.addCollisionListener(new DeployTrap(trapBottom));

        background(3);




    }


    @Override
    public Vec2 startPosition() {
        return new Vec2(22.5f,15.5f);
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
