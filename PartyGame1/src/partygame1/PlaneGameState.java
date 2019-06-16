/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Yasuki Wu
 */
public class PlaneGameState extends State {

    private Handler handler;
    private Bomber bomber;
    private ArrayList<Plane> planeList;

    public PlaneGameState(Handler handler) {
        super(handler);
        this.handler = handler;
        planeList = new ArrayList<Plane>();
        bomber = new Bomber(this.handler, 500, 500, 32, 32);
        planeList.add(new Plane(this.handler, 0, 0, 64, 64));
        planeList.add(new Plane(this.handler, 100, 500, 64, 32));
        planeList.add(new Plane(this.handler, 200, 500, 64, 32));
    }

    @Override
    public void tick() {
        bomber.tick();
        for (int x = 0; x < planeList.size(); x++) {
            planeList.get(x).tick();
        }
    }

    @Override
    public void render(Graphics g) {
        bomber.render(g);
        for (int x = 0; x < planeList.size(); x++) {
            planeList.get(x).render(g);
        }
    }

}
