/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Yasuki Wu
 */
public class Bomber extends Creature{
    private Handler handler;
    private int health;
    private BufferedImage cS;
    
    public Bomber(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        speed = (int) super.getSpeed()-1.5f;
        health = super.getHealth();
        this.handler = handler;
        xMove = 0;
        yMove = -1* speed;
        Assets.init();
        cS = Assets.bomber.get(0);
    }
    
    
    
    
    public void getInput(){
        if(handler.getKeyManager().left){
            if(yMove<=0){
                //2nd quadrant
                if(xMove<=0){
                    xMove-=0.05;
                    yMove+=0.05;
                }
                //1st quadrant
                if(xMove>=0){
                    xMove-=0.05;
                    yMove-=0.05;
                }
            }
            if(yMove>=0){
                // 3rd quadrant
                if(xMove<=0){
                    xMove+=0.05;
                    yMove+=0.05;    
                }
                // 4th quadrant
                if(xMove>=0){
                    xMove+=0.05;
                    yMove-=0.05;
                }
            }
        }
        if(handler.getKeyManager().right){
            if(yMove<=0){
                //2nd quadrant
                if(xMove<=0){
                    xMove+=0.05;
                    yMove-=0.05;
                }
                //1st quadrant
                if(xMove>=0*speed){
                    xMove+=0.05;
                    yMove+=0.05;
                }
            }
            if(yMove>=0){
                // 3rd quadrant
                if(xMove<=0){
                    xMove-=0.05;
                    yMove-=0.05;    
                }
                // 4th quadrant
                if(xMove>=0){
                    xMove-=0.05;
                    yMove+=0.05;
                }
            }
            
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
        g.drawImage(Assets.bomber.get(0),(int)x,(int)y, 64, 64,null);
    }
    
}
