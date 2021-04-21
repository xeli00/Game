package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entities.creatures.Ball;
import dev.codenmore.tilegame.entities.creatures.Balls;
import dev.codenmore.tilegame.entities.creatures.Cannon;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.gfx.Assets;

public class GameState extends State{
    
    private Player player;
    private Cannon cannon;
    private Balls balle;
    
    public GameState(Game game) {
        super(game);
        //player=new Player(game, 100,100);
        balle=new Balls();
        cannon=new Cannon(game, 500, 300, 500, 500, balle);
    }
    
    public void tick() {
       // player.tick();
        cannon.tick();
        balle.tick();
    }

    public void render(Graphics g) {
       // player.render(g);
        cannon.render(g);
        balle.render(g);
    }

}
