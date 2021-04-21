package dev.codenmore.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Iterator;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.gfx.Assets;

public class Cannon extends Creature{
    
    private Game game;
    private Balls balls;
    private Ball ball;
    private boolean ballPos;
    
    private int angle=0;
    private int i=0;

    public Cannon(Game game, float x, float y, int width, int height, Balls b) {
        super(x, y, width, height);
        this.game=game;
        this.balls=b;
        ball=new Ball(game,512,300,400,400);
        balls.addBall(ball);
        this.ballPos=true;
    }
    
    public void tick() {
        getInput();
        shot();
        newBall();
    }
    
    public void newBall() {
       if(!ball.isMove && !ballPos) {
           ball=new Ball(game,512,300,400,400);
           balls.addBall(ball);
           i++;
           System.out.println("New Bolla, "+i);
           ballPos=true;
       }
    }
    
    private void shot() {
        if(ballPos) {
            ball.directMove=(float) Math.toDegrees(Math.toRadians(angle-90));
            System.out.println(Math.toDegrees(Math.toRadians(angle)));
            ball.direct();
            ball.isMove=true;
            ballPos=false;
        }
    }

    private void getInput() {
        if(game.getkeyManager().right && this.angle<60)
            angle += (int) speed;
        if(game.getkeyManager().left && this.angle>-60)
            angle += (int)-speed;
    }

    public void render(Graphics g) {
        AffineTransform at = AffineTransform.getTranslateInstance((int)x,(int)y);
        at.rotate(Math.toRadians(angle),Assets.cannon.getWidth()/2,Assets.cannon.getHeight()/2);
        at.scale(1,1);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(Assets.cannon, at, null);
    }

}
