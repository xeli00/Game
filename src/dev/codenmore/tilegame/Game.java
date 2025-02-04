package dev.codenmore.tilegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.*;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.states.GameState;
import dev.codenmore.tilegame.states.MenuState;
import dev.codenmore.tilegame.states.State;

public class Game implements Runnable{
    private Display display;
    
    public int width,height;
    public String title;
    private Thread thread;
    private boolean running=false;
    
    private BufferStrategy bs;
    private Graphics g;
    
    private KeyManager keyManager;
    
    private State gameState;
    private State menuState;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title=title;
        this.keyManager=new KeyManager();
    }
    
    private void init() {
        this.display=new Display(title,width,height);
        this.display.getFrame().addKeyListener(keyManager);
        Assets.init();
        gameState=new GameState(this);
        menuState=new MenuState(this);
        State.setCurrentState(gameState);
    }
    
    
    
    private void tick() {
        keyManager.tick();
        
       if(State.getCurrentState() != null)
           State.getCurrentState().tick();
    }
    
    private void render() {
        bs=display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g=bs.getDrawGraphics();
        //clear screen
        g.clearRect(0, 0, width, height);
        //draw here
        if(State.getCurrentState() != null)
            State.getCurrentState().render(g);
        //end drawing!
        bs.show();
        g.dispose();
    }

    public void run() {
        init();
        int fps=60;
        double timePerTick=1000000000/fps;
        double delta=0;
        long now;
        long lastTime=System.nanoTime();
        long timer=0;
        int ticks=0;
        while(running){
            now=System.nanoTime();
            delta+=(now-lastTime)/timePerTick;
            timer+=now-lastTime;
            lastTime=now;
            
            if(delta>=1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            
            if(timer >= 1000000000) {
                System.out.println("Ticks and Frame: "+ticks);
                ticks=0;
                timer=0;
            }
        }
        stop();
    }
    
    public KeyManager getkeyManager() {
        return keyManager;
    }
    
    public synchronized void start() {
        if(running)
            return;
        running=true;
        thread=new Thread(this);
        thread.start();
    }
    
    public synchronized void stop() {
        if(!running)
            return;
        running=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
