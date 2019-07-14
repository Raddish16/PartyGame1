/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Yasuki Wu
 */
public class Animation {
    
    private int speed, index;
    private long lastTime, timer;
    private ArrayList<BufferedImage> frames;
    public Animation(int s, ArrayList<BufferedImage> f){
        speed = s;
        frames = f;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }
    
    
    public void tick(){
        timer+= System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        
        if(timer>speed){
            index++;
            timer = 0;
            if(index>=frames.size())
                index = 0;
        }
    }
    
        
    public BufferedImage getCurrentFrame(){
        return frames.get(index);
    }
    
}
