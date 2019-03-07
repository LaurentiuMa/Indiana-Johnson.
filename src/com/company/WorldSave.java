//package com.company;
//
//import org.jbox2d.common.Vec2;
//
//public class WorldSave {
//
//    int treasures,hp,level;
//    Vec2 playerPos;
//    Game game;
//
//    WorldSave(Game game){
//        this.game = game;
//        treasures = game.getPlayer().getTreasuresFound();
//        hp = game.getPlayer().getHp();
//        playerPos = game.getPlayer().getPosition();
//        level = game.getLevel();
//        if (level == 2){
//            for (int i = 0;i<2;i++){
//
//            }
//        }
//    }
//
//    public void load (Game game){
//        game.setLevel(level);
//        game.getPlayer().setTreasuresFound(treasures);
//        game.getPlayer().setHp(hp);
//        game.getPlayer().setPosition(playerPos);
//    }
//
//}
