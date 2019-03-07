package com.company;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {
    private Player player;
    private static final BodyImage backgroundLayer2 = new BodyImage("data/JungleAssets/parallax background/plx-2.png",51);
    private static final BodyImage backgroundLayer3 = new BodyImage("data/JungleAssets/parallax background/plx-3.png",51);
    private static final BodyImage backgroundLayer4 = new BodyImage("data/JungleAssets/parallax background/plx-4.png",51);
    private static final BodyImage Lv3BG = new BodyImage("data/Level3BG.jpg",40);
    public Player getPlayer() {
        return player;
    }

    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {

        player = new Player(this,game);
        player.setPosition(startPosition());
        player.setGravityScale(2);

        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));

        EndGameCollision endGame = new EndGameCollision(this);
        endGame.addCollisionListener(new KillIfTouched(getPlayer()));

        BoxShape sidePanelRightShape = new BoxShape(0.5f,25f);
        StaticBody sidePanelRight = new StaticBody(this,sidePanelRightShape);
        sidePanelRight.setPosition(new Vec2(27,0));

        BoxShape sidePanelLeftShape = new BoxShape(0.5f,25f);
        StaticBody sidePanelLeft = new StaticBody(this,sidePanelLeftShape);
        sidePanelLeft.setPosition(new Vec2(-27,0));
    }

    @SuppressWarnings("Duplicates")
    public void background(int i){
        if (i == 1){

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

        }else if (i == 2){
            BoxShape backgroundShape4 = new BoxShape(0.1f,0.1f);
            Body background4 = new StaticBody(this,backgroundShape4);
            background4.setPosition(new Vec2(0,-6));
            background4.addImage(backgroundLayer4);

            BoxShape backgroundShape = new BoxShape(0.1f,0.1f);
            Body background = new StaticBody(this,backgroundShape);
            background.setPosition(new Vec2(0,-6));
            background.addImage(backgroundLayer3);
        }else if(i == 3){
            BoxShape backgroundShape2 = new BoxShape(0.1f,0.1f);
            Body background2 = new StaticBody(this,backgroundShape2);
            background2.setPosition(new Vec2(0,0f));
            background2.addImage(Lv3BG);
        }
    }

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

    /** The initial position of the player. */
    public abstract Vec2 startPosition();

    /** The position of the exit door. */
    public abstract Vec2 doorPosition();

    /** Is this level complete? */
    public abstract boolean isCompleted();

    public abstract Color getBackgroundColor();

}
