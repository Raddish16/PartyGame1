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

/**
 *
 * @author Yasuki Wu
 */
public class Bullet extends Creature {

    private BufferedImage bullet;
    private Rectangle bounds;
    private Handler handler;
    private boolean impact;

    public Bullet(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        this.handler = handler;
        impact = false;
        bounds = new Rectangle((int)x+27, (int)y+18, 9, 8);
        bullet = Assets.turret.get(8);
        speed =5;
        xMove = 0;
        yMove = 5;
    }
    
    public void setImpact(boolean i){
        impact = i;
    }
    public boolean getImpact(){
        return impact;
    }
    
    public Rectangle getBounds(){
        return bounds;
    }

    public void move() {
        super.move();
    }

    public void tick() {
        bounds = new Rectangle((int)x+27, (int)y+18, 9, 8);
        move();
    }

    public void render(Graphics g) {
        if(!impact){
            g.drawImage(bullet, (int) x, (int) y, width, height, null);
            g.setColor(Color.black);
            g.drawRect((int)x+27, (int)y+18, 9, 8);
        }
    }
    

    public void addxMove(int x) {
        xMove += x;
    }

    public void addyMove(int y) {
        yMove += y;
    }
    public void setyMove(int y){
        yMove = y;
    }
}
