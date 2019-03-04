package com.company;

import javax.swing.*;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;


public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world  */
    private UserView view;

    private static final BodyImage backgroundLayer3 = new BodyImage("data/JungleAssets/parallax background/plx-3.png",40);
    private static final BodyImage backgroundLayer4 = new BodyImage("data/JungleAssets/parallax background/plx-4.png",40);
    private static final BodyImage backgroundLayer2 = new BodyImage("data/JungleAssets/parallax background/plx-2.png",40);

    private int level;

    private Controller controller;

    public Game() {

        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);

        // make a view
        view = new UserView(world, 1024, 768);

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

        view.setBackground(Color.getHSBColor(80,68,40));

        // start!
        world.start();
    }

    /** The player in the current level. */
    public Player getPlayer() {
        return world.getPlayer();
    }

    /** Is the current level of the game finished? */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /** Advance to the next level of the game. */
    public void goNextLevel() {
        world.stop();
        if (level == 2) {
            System.exit(0);
        } else {
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);

            world.start();
        }
    }

    public static void main(String[] args) {
        new Game();
    }
    public UserView getView(){return view;}
}
