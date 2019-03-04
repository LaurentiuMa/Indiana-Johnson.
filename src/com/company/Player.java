package com.company;

import city.cs.engine.*;

public class Player extends Walker {

    private BodyImage image = new BodyImage("data/JungleAssets/Character/sprites/idle.gif", 2.7f);
    private static final Shape playerShape = new PolygonShape(

            -0.749f,1.345f, -0.749f,-1.339f, 0.741f,-1.339f, 0.747f,1.345f
    );
    private int treasuresFound;
    private int hp;

    public Player(World w){
        super(w, playerShape);
        addImage(image);
        treasuresFound = 0;
        hp = 100;
    }

    public int getCount(){
        return treasuresFound;
    }

    public void incrementTreasuresFound(){
        treasuresFound++;
        System.out.println("Found " + treasuresFound);
    }

    public void reduceHp(int amount){
        hp -= amount;
    }






}