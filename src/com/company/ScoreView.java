package com.company;

import java.awt.Graphics2D;
import city.cs.engine.*;

/**
 * extended view
 */
public class ScoreView extends UserView {
    
    private Game game;
        
    public ScoreView(World world, Game game, int width, int height) {
        super(world, width, height);
        this.game = game;
    }
    
    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawString("Treasures: " + game.getPlayer().getTreasuresFound(), 10, 20);
        g.drawString("Health: " + game.getPlayer().getHp(),950,20);
    }
}
