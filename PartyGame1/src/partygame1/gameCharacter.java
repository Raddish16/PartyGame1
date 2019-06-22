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

    private String charName;
    private ArrayList<BufferedImage> charImage;
    private BufferedImage first;
    private int count;

    public gameCharacter(Handler handler, float x, float y, int width, int height, String charName) {
        super(handler, x, y, width, height);
        this.charName = charName;
        if(charName.equalsIgnoreCase("Puppet")){
            charImage = Assets.puppet;
        }else if(charName.equalsIgnoreCase("mower")){
            charImage = Assets.mower;
        }else if(charName.equalsIgnoreCase("Fisher") || charName.equalsIgnoreCase("Fisherman")){
            charImage = Assets.fisher;
        }
        //first = charImage.get(0);
    }
    
    public void tick() {
        count++;
        xMove = 1;//Add different controls based on which player they are
        yMove = 1;
        move();
    }

    public void render(Graphics g) {
        g.drawImage(Assets.mouse.get(0), (int) x, (int) y, 32, 32, null);
    }
}
