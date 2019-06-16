/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Graphics;
import static java.lang.Math.sin;

/**
 *
 * @author Yasuki Wu
 */
public class Plane extends Creature {

    private Handler handler;
    private double count = 0;
    private int moveMethod = 0;

    public Plane(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        this.handler = handler;
        Assets.init();
        xMove = 0;
        yMove = -1;
        moveMethod = (int)(Math.random() * 3);
    }

    public void move() {
        super.move();;
    }

    public void tick() {
        count += .5;
        if (moveMethod == 1) {
            xMove = -(int) (5 * sin(count)) + (int) (.25 * count);
            yMove = -(int) (5 * sin(count)) - (int) (.25 * count);
            
        } else if (moveMethod == 2) {
            xMove = (int) (5 * count);
            yMove = -(int) (5 * count);
            
        }else{
            xMove = 4;
            yMove = -4;
            
        }
        move();
    }

    public void render(Graphics g) {
        g.drawImage(Assets.plane.get(0), (int) x, (int) y, 64, 64, null);
    }

}
