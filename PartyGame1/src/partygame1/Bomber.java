/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Yasuki Wu
 */
public class Bomber extends Creature{
    private Handler handler;
    private int health,rotated;
    private BufferedImage cS,newCs;
    
    
    public Bomber(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        speed =  4.5f;
        health = super.getHealth();
        this.handler = handler;
        xMove = 0;
        yMove = -1* speed;
        rotated = 0;
        Assets.init();
        cS = Assets.bomber.get(0);
    }
    
    
    public void rotateImage(double degrees){
        BufferedImage newI = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        Graphics2D  g2= (Graphics2D)newI.getGraphics();
        g2.rotate(Math.toRadians(degrees),width/2,height/2);
        g2.drawImage(cS,0,0,null);
        cS = newI;
        g2.dispose();
    }
    public BufferedImage newRotateImage(double degrees){
        BufferedImage newI = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        Graphics2D  g2= (Graphics2D)newI.getGraphics();
        g2.rotate(Math.toRadians(degrees),width/2,height/2);
        g2.drawImage(cS,0,0,null);
        newCs = newI;
        return newCs;
    }
    
    public void getInput(){
        if(handler.getKeyManager().left){
            rotated-=1;
            newCs = newRotateImage(rotated);
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
            rotateImage(90);
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
        g.drawImage(newCs,(int)x,(int)y, 64, 64,null);
    }
    
}
