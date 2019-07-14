/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import static java.lang.Math.sin;

/**
 *
 * @author Yasuki Wu
 */
public class Plane extends Creature {

    private Handler handler;
    private double count = 0;
    private int fireCount,moveMethod = 0;
    private Rectangle bounds;
    private BufferedImage currIm;
    private boolean death;

    public Plane(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        this.handler = handler;
        bounds = new Rectangle((int)x+18,(int)y+16,28,22);
        Assets.init();
        currIm = ImageRotate.newRotateImage(180, Assets.plane.get(0));
        fireCount = 0;
        xMove = 0;
        yMove = -1;
        moveMethod = (int) (Math.random() * 4);
        death = false;
    }

    public void move() {
        super.move();;
    }
    public void resetCount(){
        count = 0;
    }
    public Rectangle getBounds(){
        return bounds;
    }
    public void setDeath(Boolean d){
        death = d;
    }
    public boolean getDeath(){
        return death;
    }

    public void tick() {
        fireCount++;
        if(fireCount>60){
            fireCount = 0;
            Bullet bu = new Bullet(handler,x,y,width,height);
            bu.setyMove((int)(2*this.yMove));
            PlaneGameState.enemyBullets.add(bu);
        }
        bounds = new Rectangle((int)x+18,(int)y+16,28,22);
        count += .5;
        /*if (moveMethod == 1) {
            
            xMove = -(int) (5 * sin(count)) + (int) (.25 * count);
            yMove = -(int) (5 * sin(count)) - (int) (.25 * count);

        } else if (moveMethod == 2) {
            
            xMove = 10 + (int)(.4*count);
            yMove = (int)(-count + 11 );

        } else if (moveMethod == 3) {
            
            xMove = 12 + (int)(.25*count);
            yMove = (int)(-count + 15 );
            
        } else {
            xMove = 4;
            yMove = -4;

        }*/
        yMove = 4;
        
        move();
    }

    public void render(Graphics g) {
        if(!death)
            g.drawImage(currIm, (int) x, (int) y, 64, 64, null);
        g.setColor(Color.black);
        g.drawRect((int)x+18,(int)y+20,28,22);
    }

}
