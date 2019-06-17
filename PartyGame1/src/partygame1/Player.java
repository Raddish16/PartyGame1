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
    private int count, mouse = 0;
    private double count2, first = 0;
    private boolean moveR = true;
    private float pastX, pastY;

    public Player(Handler handler, float x, float y, int w, int h) {
        super(handler, x, y, w, h);
        this.handler = handler;

    }

    public void tick() {
        count2 += 0.5;
        count++;
        if (count % 20 == 0) {
            mouse++;
        }
        if (mouse == 6) {
            mouse = 0;
            count = 0;
        }

        pastX = super.getX();

        if (handler.getName().equals("menuState"))/*This will always be true, fix*/ {
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
                g.drawImage(Assets.madmouseR.get(mouse), (int) x, (int) y, 70, 70, null);
            } else if (handler.getMouseManager().isLeftPressed() && moveR == false) {
                g.drawImage(Assets.madmouseL.get(mouse), (int) x, (int) y, 70, 70, null);
            } else if (moveR == true) {
                g.drawImage(Assets.normouseR.get((int) count2 % 8), (int) x, (int) y, 70, 70, null);
                mouse = 0;
                count = 0;
            } else {
                g.drawImage(Assets.normouseL.get((int) count2 % 8), (int) x, (int) y, 70, 70, null);
                mouse = 0;
                count = 0;
            }
        }
    }

}
