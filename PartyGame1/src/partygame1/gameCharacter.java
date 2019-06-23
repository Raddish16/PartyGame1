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
    private double count, frames;
    private int charNum;
    private static int charCount;

    public gameCharacter(Handler handler, float x, float y, int width, int height, String charName) {
        super(handler, x, y, width, height);
        this.charName = charName;
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
        if (charName.equalsIgnoreCase("Puppet")) {
            g.drawImage(Assets.puppet.get((int)(.5*count % 2) + 3), (int) x, (int) y, 32*5, 96*5, null);
        } else if (charName.equalsIgnoreCase("mower")) {
            g.drawImage(Assets.mower.get((int)(count % Assets.mower.size())), (int) x, (int) y, 30*5, 30*5, null);
        } else if (charName.equalsIgnoreCase("Fisher") || charName.equalsIgnoreCase("Fisherman")) {
            g.drawImage(Assets.fisher.get((int)(count%Assets.fisher.size())), (int) x, (int) y, 32*6, 32*6, null);
        }

    }
}
