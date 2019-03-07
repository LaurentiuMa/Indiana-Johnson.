package com.company;

import city.cs.engine.*;
import city.cs.engine.Shape;

import java.awt.*;

public class Player extends Walker {

    private BodyImage image = new BodyImage("data/JungleAssets/Character/sprites/idle.gif", 2.7f);
    private static final Shape playerShape = new PolygonShape(

            -0.749f,1.345f, -0.749f,-1.339f, 0.741f,-1.339f, 0.747f,1.345f
    );
    private int treasuresFound;
    private int hp;
    private Game game;



    public Player(World w, Game game){
        super(w, playerShape);
        addImage(image);
        treasuresFound = 0;
        this.game = game;
        hp = 100;
    }

    public int getTreasuresFound(){
        return treasuresFound;
    }

    public void incrementTreasuresFound(){
        treasuresFound++;
        System.out.println("Found " + treasuresFound);
        game.changed();
    }

    public void reduceHp(int amount){
        hp -= amount;
    }
    public int getHp(){return hp;}
    public void setTreasuresFound(int treasures) {
        this.treasuresFound = treasures;
    }
    public void setHp(int hp){this.hp = hp;}
    public void kill(){hp = 0; }


    }