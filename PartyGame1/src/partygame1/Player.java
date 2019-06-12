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
public class Player extends Creature {

    private Game game;private double count = 0;
    
    public Player(Handler handler, float x, float y, int w, int h) {
        super(handler, x, y, w, h);
        this.game = handler.getGame();

    }

    public void tick() {
        count += .1;
        if (game.getKeyManager().up) {
            y -= 3;
        }
        if (game.getKeyManager().down) {
            y += 3;
        }
        if (game.getKeyManager().left) {
            x -= 3;
        }
        if (game.getKeyManager().right) {
            x += 3;
        }
    }

    public void render(Graphics g) {
        
        g.drawImage(Assets.mouse.get((int)count%16), (int) x, (int) y, 70, 70, null);
        
    }
}
