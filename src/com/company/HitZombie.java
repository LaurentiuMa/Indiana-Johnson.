package com.company;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class HitZombie implements CollisionListener {

    private ZombieBoss zombieBoss;

    public HitZombie(ZombieBoss zombieBoss) {
        this.zombieBoss = zombieBoss;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == zombieBoss) {
                zombieBoss.reduceHp(25);
                System.out.println("25 Damage dealt");
                System.out.println(zombieBoss.getHp());
                if (zombieBoss.getHp() <= 0){
                    zombieBoss.destroy();
                }
            e.getReportingBody().destroy();
        }
    }
}

