package com.company;

import city.cs.engine.*;

public class Slime extends Walker {

    private int hp;
    private static final Shape slimeShape = new PolygonShape(
            -0.747f,-0.747f, 0.744f,-0.747f, 0.744f,-0.609f, 0.444f,0.69f, -0.357f,0.705f, -0.741f,-0.702f
    );
    private BodyImage faceRight = new BodyImage("data/slime.gif",2f);

    public Slime(World w) {
        super(w, slimeShape);
        addImage(faceRight);
        hp = 150;
        setGravityScale(100);
    }

    public int getHp() {
        return hp;
    }
    public void reduceHp(int amount){
        hp -= amount;
    }

}
