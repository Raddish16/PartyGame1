/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author brendanwilhelm
 */
public class gameCharacter extends Creature {

    
    private ArrayList<BufferedImage> charImage;
    private BufferedImage first;
    protected double count, frames;
    private int charNum;
    private static int charCount;

    public gameCharacter(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        
        charCount++;
        charNum = charCount;
    }

    public void tick() {
        count+= .2;
        if (handler.getGame().getKeyManager().up) {
            yMove = -3;
        }
        else if (handler.getGame().getKeyManager().down) {
            yMove = 3;
        }else{
            yMove = 0;
        }
        if (handler.getGame().getKeyManager().left) {
            xMove = -3;
        }
        else if (handler.getGame().getKeyManager().right) {
            xMove = 3;
        }else{
            xMove = 0;
        }

        move();
    }

    public void render(Graphics g) {        

    }
}
