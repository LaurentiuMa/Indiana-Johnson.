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
        return getPlayer().getTreasuresFound() == NUM_TREASURES;
    }

    @Override
    public Color getBackgroundColor(){return Color.getHSBColor(80,68,40);}
}
