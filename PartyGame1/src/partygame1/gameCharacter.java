/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author brendanwilhelm
 */
public class gameCharacter extends Creature {

    private String charName;
    private BufferedImage[] charImage;

    public gameCharacter(Handler handler, float x, float y, int width, int height, String charName) {
        super(handler, x, y, width, height);
        this.charName = charName;
        //charImage = Assets.retrieve(charName);
        
    }

    public void tick() {
        xMove = 1;//Add different controls based on which player they are
        yMove = 1;
        move();
    }

    public void render(Graphics g) {
        g.drawImage(charImage[0], (int) x, (int) y, 32, 32, null);
    }
}
