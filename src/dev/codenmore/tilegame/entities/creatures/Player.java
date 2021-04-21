package dev.codenmore.tilegame.entities.creatures;

import java.awt.Graphics;

import dev.codenmore.tilegame.Game;

import dev.codenmore.tilegame.gfx.Assets;

public class Player extends Creature{
    
    private Game game;

    public Player(Game game, float x, float y) {
        super(game.width/2, game.height/2, Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
        this.game=game;
    }

    @Override
    public void tick() {
        getInput();
        move();
    }
    
    private void getInput() {
        xMove=0;
        yMove=0;
        if(game.getkeyManager().up)
            yMove = -speed;
        if(game.getkeyManager().down)
            yMove = speed;
        if(game.getkeyManager().right)
            xMove = speed;
        if(game.getkeyManager().left)
            xMove = -speed;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int)x, (int)y, width, height, null);
    }

}
