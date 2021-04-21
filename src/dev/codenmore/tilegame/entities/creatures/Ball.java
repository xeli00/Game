package dev.codenmore.tilegame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.gfx.Assets;

public class Ball extends Creature{
    
    private Game game;
    public boolean isMove;
    public float directMove;

    public Ball(Game game, float x, float y, int width, int height) {
        super(x, y, width, height);
        this.game=game;
        this.isMove=false;
        this.directMove=0;
    }


    public void tick() {
        if(isMove) {
            move();
            destroy();
        }
    }
    
    public void direct() {
        this.setxMove(Math.cos(Math.toRadians(directMove))*this.speed);
        System.out.println("Xmove: "+Math.cos(Math.toRadians(directMove))*this.speed);
        this.setyMove(Math.sin(Math.toRadians(directMove))*this.speed);
        System.out.println("Ymove: "+Math.sin(Math.toRadians(directMove))*this.speed);
    }
    
    private void destroy() {
        System.out.println(this.y);
        if(this.x>=1000 || this.x <=-200) {
            this.xMove*=-1;
        }else if(this.y <= -100) {
            System.out.println("Destroy");
            this.isMove=false;
        }
    }

    public void render(Graphics g) {
        g.drawImage(Assets.ballBlue, (int)x, (int)y, width, height, null);
    }

}
