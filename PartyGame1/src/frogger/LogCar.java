/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import partygame1.Entity;
import partygame1.Game;
import partygame1.Handler;
import partygame1.imageLoader;

/**
 *
 * @author 770771
 */
public class LogCar extends Entity {

    private Game game;
    private BufferedImage image;
    private int counter;

    public boolean isLog;
    public int length;
    public int every;
    public boolean moveRight;
    public boolean isAlive;
    public int speed = (int) (Math.random() * 5) + 2;
    public static int[] posarr = new int[800];
    private Rectangle r;
    public int lengthLog;
    private Handler handler;

    public LogCar(Handler h, float x, float y, int width, int height) {
        super(h, x, y, width, height);
        every = 10000;
        moveRight = true;
        counter = 0;
        double rando = Math.random();
        r = new Rectangle((int) x + 5, (int) y + 19, 52, 25);
        if (rando >= .6) {
            isLog = true;
            image = imageLoader.loadImage("/textures/New Piskel-2.png");
            lengthLog = (int) Math.random() * 3 + 1;

        } else {
            isLog = false;
            if (Math.random() > 0.5) {
                image = imageLoader.loadImage("/textures/car.png.png");
            } else {
                image = imageLoader.loadImage("/textures/RedCarLeft.png");
            }

        }

        if (isLog) {
            length = (int) (Math.random() * 3) + 3;
        } else {
            length = (int) (Math.random() * 2) + 1;
        }
        posarr[(int) y]++;
    }

    public LogCar(Handler h, float x, float y, int wid, int height, boolean log) {
        super(h, x, y, wid, height);
        isLog = log;
        if (isLog) {
            length = (int) (Math.random() * 3) + 3;
        } else {
            length = (int) (Math.random() * 2) + 1;
        }

        every = 10000;
        moveRight = true;
        counter = 0;

        r = new Rectangle((int) x + 5, (int) y + 19, 52, 25);
        if (isLog) {
            image = imageLoader.loadImage("/textures/New Piskel-2.png");
        } else {
            if (Math.random() > 0.5) {
                image = imageLoader.loadImage("/textures/car.png.png");
            } else {
                image = imageLoader.loadImage("/textures/RedCarLeft.png");
            }
        }

        if (isLog) {
            length = (int) (Math.random() * 3) + 3;
        } else {
            length = (int) (Math.random() * 2) + 1;
        }
        posarr[(int) y]++;
    }

    public LogCar(Handler h, float x, float y,int wid, int he, boolean log, int spd, boolean dirck) {
        super(h,x, y, wid, he);
        isLog = log;
        speed = spd;
        moveRight = dirck;
        every = 10000;

        counter = 0;

        r = new Rectangle((int) x + 5, (int) y + 19, 52, 25);

        if (isLog) {
            image = imageLoader.loadImage("/textures/New Piskel-2.png");
        } else {
            if (Math.random() > 0.5) {
                image = imageLoader.loadImage("/textures/car.png.png");
            } else {
                image = imageLoader.loadImage("/textures/RedCarLeft.png");
            }
        }

        if (isLog) {
            length = (int) (Math.random() * 3) + 3;
        } else {
            length = (int) (Math.random() * 2) + 1;
        }
        posarr[(int) y]++;
    }

    public int getLength() {
        return length;
    }

    public void spawnTime(int y) {
        every = y;
    }

    public void setDirection(boolean isR) {
        moveRight = isR;
        if (!isLog) {
            if (!isR) {
                image = imageLoader.loadImage("/textures/carleft.png");
            } else {
                image = imageLoader.loadImage("/textures/car.png.png");
            }

        } else {
            image = imageLoader.loadImage("/textures/Log2-1.png.png");
        }
    }

    public boolean getDirection() {
        return moveRight;
    }

    public void setAlive(boolean live) {
        isAlive = live;
    }

    public boolean getAlive() {
        return isAlive;
    }

    public boolean getLog() {
        return isLog;
    }

    public void tick() {
        counter++;

        if (getDirection()) {
            x += speed;
        } else {
            x -= speed;
        }

    }

    public void render(Graphics graph) {
        graph.drawImage(image, (int) x, (int) y, null);
    }

    public LogCar getLC() {
        return this;
    }

    public float getPosition() {
        return super.y;
    }

    public float getX() {
        return super.x;
    }

   // public void setPosition(float newpos) {
   //     super.setPosition(newpos);
    //}

    public void setX(float thenumbergetsreallybigsometimes) {
        super.setX(thenumbergetsreallybigsometimes);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x + 5, (int) y + 19, 52, 25);
    }

    public int getPAr() {
        return posarr[(int) getPosition()];
    }

    public int getSpeed() {

        return speed;
    }
}
