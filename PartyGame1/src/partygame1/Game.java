/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Display display;
    public int width, height;
    public String title;

    private Thread thread;
    private boolean running = false;

    private BufferStrategy bStrat;
    private Graphics graph;
    private BufferedImage image;

    public State gameState;
    private State menuState;

    private KeyManager keyManager;
    private MouseManager mouseManager;

    //private GameCamera gameCamera;
    private Handler handler;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    private void init() {
        Assets.init();
        display = new Display(title, width, height);

        display.getFrame().addKeyListener(keyManager);//Get jframe, add keylistener which allows access to keyboard

        display.getFrame().addMouseListener(mouseManager);//Need to add both in canvas and jframe to work properly
        display.getFrame().addMouseMotionListener(mouseManager);

        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        handler = new Handler(this);
        
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        
        State.setState(menuState);

    }

    private void tick() {
        keyManager.tick();
        

        if (State.getState() != null) {
            State.getState().tick();
        }

    }

    private void render() {
        bStrat = display.getCanvas().getBufferStrategy();
        if (bStrat == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graph = bStrat.getDrawGraphics();

        graph.clearRect(0, 0, width, height);

        if (State.getState() != null) {
            State.getState().render(graph);

        }

        bStrat.show();
        graph.dispose();

    }

    public void run() {
        init();

        int fps = 60;  //Times running tick and render every second
        double tickTime = 1000000000 / fps; // time in nano seconds to execute tick and render
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();//current time of computer in nanoseconds
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / tickTime;//adds amount of time since line last ran, div by max time allowed
            timer += now - lastTime;//adds amount of time passed since lina above last ran
            lastTime = now;

            //if the time accumulates to over 1, need to tick and render to maintain framerate
            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
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

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();

    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //getters
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public State getState() {
        return State.getState();
    }

    public Display getDisplay() {
        return display;
    }

    public Graphics getGraphics() {
        return graph;
    }
}
