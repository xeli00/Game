package dev.codenmore.tilegame.entities.creatures;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class Balls {
    
    private ArrayList<Ball> bolle;

    public Balls() {
        bolle = new ArrayList<>();
    }
    
    public void tick() {
        Iterator<Ball> ba = bolle.iterator();
        while(ba.hasNext()) {
            Ball b = ba.next();
            b.tick();
        }
    }
    
    public int numBolle() {
        return bolle.size();
    }
    
    public ArrayList<Ball> getBolle() {
        return bolle;
    }

    public void render(Graphics g) {
        for(Ball b : bolle) {
            b.render(g);
        }
    }
    
    public void addBall(Ball b) {
        bolle.add(b);
    }

}
