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

    private Game game;
    private double count = 0;
    private double first = 0;

    public Player(Handler handler, float x, float y, int w, int h) {
        super(handler, x, y, w, h);
        this.game = handler.getGame();
        
    }

    public void tick() {
        count += .05;

        if (State.getState() == handler.getGame().getState())/*This will always be true, fix*/ {
            x = -45 + game.getMouseManager().getMouseX();
            y = -28 + game.getMouseManager().getMouseY();
        } else {
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
    }

    public void render(Graphics g) {
        if (handler.getMouseManager().isLeftPressed()) {
            //I want it to do the initial click as him getting bopped on the head, I can't figure it out
            g.drawImage(Assets.madmouse.get(0), (int) x, (int) y, 70, 70, null);
        } else {
            g.drawImage(Assets.normouse.get((int) count % 8), (int) x, (int) y, 70, 70, null);
        }
    }
}
