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

    private Handler handler;
    private double count = 0;
    private double first = 0;
    private boolean moveR = true;
    private float pastX, pastY;

    public Player(Handler handler, float x, float y, int w, int h) {
        super(handler, x, y, w, h);
        this.handler = handler;

    }

    public void tick() {
        count += .05;
        pastX = super.getX();

        if (State.getState() == handler.getGame().getState())/*This will always be true, fix*/ {
            x = -40 + handler.getGame().getMouseManager().getMouseX();
            y = -23 + handler.getGame().getMouseManager().getMouseY();
        } else {
            if (handler.getGame().getKeyManager().up) {
                y -= 3;
            }
            if (handler.getGame().getKeyManager().down) {
                y += 3;
            }
            if (handler.getGame().getKeyManager().left) {
                x -= 3;
            }
            if (handler.getGame().getKeyManager().right) {
                x += 3;
            }
        }
        if (pastX == x) {

        } else if (pastX < x) {
            moveR = true;
        } else {
            moveR = false;
        }

    }

    public void render(Graphics g) {
        if (handler.getName().equals("menuState")) {
            if (handler.getMouseManager().isLeftPressed() && moveR == true) {
                //I want it to do the initial click as him getting bopped on the head, I can't figure it out
                g.drawImage(Assets.madmouseR.get(0), (int) x, (int) y, 70, 70, null);
            } else if (handler.getMouseManager().isLeftPressed() && moveR == false) {
                g.drawImage(Assets.madmouseL.get(0), (int) x, (int) y, 70, 70, null);
            } else if (moveR == true) {
                g.drawImage(Assets.normouseR.get((int) count % 8), (int) x, (int) y, 70, 70, null);
            } else {
                g.drawImage(Assets.normouseL.get((int) count % 8), (int) x, (int) y, 70, 70, null);
            }
        }
    }

}
