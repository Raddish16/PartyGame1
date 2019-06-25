/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Graphics;

/**
 *
 * @author brendanwilhelm
 */
public class Mower extends gameCharacter {
    
    private int imgheight = 32, imgwidth = 32;
    
    public Mower(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        
    }

    public void tick() {
        super.tick();
    }

    public void render(Graphics g) {
        /*if (handler.getKeyManager().up ) {
            g.drawImage(Assets.madmouseR.get(mouse), (int) x, (int) y, 70, 70, null);
        }
        if (handler.getKeyManager().down ) {
            g.drawImage(Assets.madmouseL.get(mouse), (int) x, (int) y, 70, 70, null);
        }*/
        if (handler.getKeyManager().left) {
            g.drawImage(Assets.mower.get((int) (count % Assets.mower.size())), (int) x, (int) y, -30 * 5, 30 * 5, null);
        } else if (handler.getKeyManager().right) {
            g.drawImage(Assets.mower.get((int) (count % Assets.mower.size())), (int) x, (int) y, 30 * 5, 30 * 5, null);

        } else {
            g.drawImage(Assets.mower.get(0), (int) x, (int) y, 30 * 5, 30 * 5, null);

        }
    }
}
