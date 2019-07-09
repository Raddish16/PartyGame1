/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.image.BufferedImage;

/**
 *
 * @author Yasuki Wu
 */
public class Animation {
    
    private int speed, index;
    private BufferedImage frames;
    public Animation(int s, BufferedImage f){
        speed = s;
        frames = f;
    }
    
}
