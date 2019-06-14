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
public class Bomber extends Creature{
    private Handler handler;
    private int health;
    private float speed;
    
    
    
    public Bomber(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        speed = (int) super.getSpeed();
        health = super.getHealth();
        this.handler = handler;
        xMove = 0;
        yMove = -1* defaultSpeed;
       
    }
    
    public void getInput(){
        if(handler.getKeyManager().left){
            xMove -=1.05 ;
            yMove-=1.0f;
        }
        if(handler.getKeyManager().left){
            xMove+=1.0f;
            yMove+=1.0f;
        }
    }
    
    public void move(){
        super.move();
    }
    
    public void tick(){
        getInput();
        move();
    }
    public void render(Graphics g){
        g.drawRect((int)x,(int)y, width, height);
    }
    
}
