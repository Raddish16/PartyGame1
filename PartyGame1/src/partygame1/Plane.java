/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Graphics;

/**
 *
 * @author Yasuki Wu
 */
public class Plane extends Creature{
    private Handler handler;
    
    public Plane(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        this.handler = handler;
        Assets.init();
        xMove = 0;
        yMove = -1;
    }
    
    public void move(){
        super.move();;
    }
    public void tick(){
        move();
    }
    public void render(Graphics g){
        g.drawImage(Assets.plane.get(0),(int)x,(int)y,64,64, null);
    }
    
    
    
}
