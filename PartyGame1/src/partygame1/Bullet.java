/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Yasuki Wu
 */
public class Bullet extends Creature{
    private BufferedImage bullet;
    private Rectangle bounds;
    private Handler handler;
    public Bullet(Handler handler, float x, float y, int width, int height) {
        super(handler, x+width/2, y+height/2, width, height);
        this.handler = handler;
        bounds = new Rectangle((int)x,(int)y,width,height);
        bullet = Assets.bRobot.get(0);
        xMove = 0;
        yMove = -5;
    }
    public void move(){
        super.move();
    }
    public void tick(){
        move();
    }
    public void render(Graphics g){
        g.drawImage(bullet, (int)x, (int)y, null);
    }
    
}