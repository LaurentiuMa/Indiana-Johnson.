package com.company;

import city.cs.engine.BodyImage;
import city.cs.engine.Walker;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_SPACE;

public class Controller extends KeyAdapter {

    private float JUMPING_SPEED = 11;
    private float WALKING_SPEED = 4;
    private int jumpsRemaining = 2;
    private Player body;

    public Controller(Player body) {
        this.body = body;
        body.setGravityScale(2);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        /*resets the jump limit if the player is on the ground straight after a key is pressed*/
    if (body.getLinearVelocity().y == 0){
        jumpsRemaining = 2;
    }

        if (code == KeyEvent.VK_W) {
            Vec2 v = body.getLinearVelocity();
            /* checks to see if the player is already jumping and if he has anymore jumps left
            this is used for the double jump mechanic */
            if (Math.abs(v.y) < 0.01f && jumpsRemaining != 0) {
                /*if he is jumping facing left (hence the negative v), it loads the jumping left animation )*/
                if (body.getLinearVelocity().x < 0) {
                    body.removeAllImages();
                    body.addImage(new BodyImage("data/JungleAssets/Character/sprites/jump_left.png",2.7f));
                    /*else it loads the jumping right animation since we already settled that the character IS jumping*/
                } else {
                    body.removeAllImages();
                    body.addImage(new BodyImage("data/JungleAssets/Character/sprites/jump.png",2.7f));
                }

                body.jump(JUMPING_SPEED);
                jumpsRemaining=1;
                /*second jump, after this, the character is no longer allowed to jump*/
            }else if (Math.abs(v.y) > 0.01f && jumpsRemaining != 0){
                body.setLinearVelocity(new Vec2(0,JUMPING_SPEED));
                jumpsRemaining = 0;
            }
            /*Standard, if d pressed, move right, load the respective animation*/
        }else if (code == KeyEvent.VK_D) {
            Vec2 v2 = body.getLinearVelocity();
            if (Math.abs(v2.y) < 0.01f ) {
                body.startWalking(WALKING_SPEED);
                body.removeAllImages();
                body.addImage(new BodyImage("data/JungleAssets/Character/sprites/run.gif", 2.7f));
            }
            /*vice versa to the comment above*/
        } else if (code == KeyEvent.VK_A ) {
            Vec2 v3 = body.getLinearVelocity();
            if (Math.abs(v3.y) < 0.01f) {
            body.startWalking(-WALKING_SPEED);
            body.removeAllImages();
            body.addImage(new BodyImage("data/JungleAssets/Character/sprites/run_left.gif",2.7f));
            }
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_D) {
            body.stopWalking();
            body.removeAllImages();
            body.addImage(new BodyImage("data/JungleAssets/Character/sprites/idle.gif", 2.7f));
        } else if (code == KeyEvent.VK_A) {
            body.stopWalking();
            body.getLinearVelocity().x = 0;
            body.removeAllImages();
            body.addImage(new BodyImage("data/JungleAssets/Character/sprites/idle_facing_left.gif",2.7f));
        }

        }

    public void setBody(Player body) {
        this.body = body;
    }

    }










