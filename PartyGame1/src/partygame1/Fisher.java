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
public class Fisher extends gameCharacter {

    private int imgheight = 50, imgwidth = 50;
    
    public Fisher(Handler handler, float x, float y, int width, int height) {
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
            g.drawImage(Assets.fisher.get((int) (count % Assets.fisher.size())), (int) x, (int) y, 32 * 6, 32 * 6, null);
        } else if (handler.getKeyManager().right) {
            g.drawImage(Assets.fisher.get((int) (count % Assets.fisher.size())), (int) x, (int) y, 32 * 6, 32 * 6, null);
        } else {
            g.drawImage(Assets.fisher.get(0), (int) x, (int) y, 32 * 6, 32 * 6, null);

        }
    }
}
