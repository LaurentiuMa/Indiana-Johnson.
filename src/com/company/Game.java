package com.company;

import javax.swing.*;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;


public class Game extends Model {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;

    /**
     * A graphical display of the world
     */
    private UserView view;

    private int level;

    private Controller controller;

    public Game() {

        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);

        // make a view
        view = new ScoreView(world, this, 1024, 768);
        view.setBackground(world.getBackgroundColor());
        // uncomment this to draw a 1-metre grid over the view
        view.setGridResolution(1);

        // display the view in a frame
        final JFrame frame = new JFrame();

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);

        frame.requestFocus();

        //view.addKeyListener(new GiveFocus(frame));

        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);

        // uncomment this to make a debugging view
        JFrame debugView = new DebugViewer(world, 500, 500);


        // start!
        world.start();
    }

    /**
     * The player in the current level.
     */
    public Player getPlayer() {
        return world.getPlayer();
    }

    /**
     * Is the current level of the game finished?
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /**
     * Advance to the next level of the game.
     */
    public void goNextLevel() {
        world.stop();
        Player oldPlayer = world.getPlayer();
        if (level == 3) {
            System.exit(0);
        } else if (level == 1) {
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            world.getPlayer().setTreasuresFound(oldPlayer.getTreasuresFound());
            world.getPlayer().setHp(oldPlayer.getHp());
            // show the new world in the view
            view.setWorld(world);
            view.setBackground(world.getBackgroundColor());
            world.start();
        } else if (level == 2) {
            level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            world.getPlayer().setTreasuresFound(oldPlayer.getTreasuresFound());
            // show the new world in the view
            view.setWorld(world);
            world.start();
        }
    }

    public static void main(String[] args) {
        new Game();
    }

    public UserView getView() {
        return view;
    }

    public int getLevel(){return level;}

    public void setLevel(int level){
        this.level = level;
        level--;
        goNextLevel();
    }

}