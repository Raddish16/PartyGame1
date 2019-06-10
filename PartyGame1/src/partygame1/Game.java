/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author Yasuki Wu
 */
public class Game implements Runnable{
    private Display display;
    private int width, height;
    private String title;
    private Thread thread;
    private boolean running = false;
    private BufferStrategy bStrat;
    private Graphics graph;
    public Game(String t, int w, int h){
        title = t;
        width = w;
        height = h;
    
    }
    
    private void init(){
        display = new Display(title, width, height);
        
    }
    
    private void tick(){
        
        
    }
    
    private void render(){
        bStrat = display.getCanvas().getBufferStrategy();
        if( bStrat == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graph = bStrat.getDrawGraphics();
        
        
        bStrat.show();
        graph.dispose();
    }
    
    public void run(){
        init();

        int fps = 60;  //Times running tick and render every second
        double tickTime = 1000000000/ fps; // time in nano seconds to execute tick and render
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();//current time of computer in nanoseconds
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / tickTime;//adds amount of time since line last ran, div by max time allowed
            timer += now - lastTime;//adds amount of time passed since lina above last ran
            lastTime = now;

            //if the time accumulates to over 1, need to tick and render to maintain framerate
            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta --;
            }
            if (timer >= 1000000000) //when timer == 1 billion nanoseconds or 1 second, display ticks per second
            {
                System.out.println("Ticks: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }


        stop();
        
    }
    
    public synchronized void start(){
        if(running)
        {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
        
    }
    
    public synchronized void stop(){
        if(!running)
        {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
