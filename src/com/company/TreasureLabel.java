package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TreasureLabel extends JLabel implements ChangeListener {

    Game game;
    String treasuresFound;

    TreasureLabel(Game game){
        this.game = game;
        treasuresFound = Integer.toString(game.getPlayer().getTreasuresFound());
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        setText(Integer.toString(game.getPlayer().getTreasuresFound()));
    }

}
