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
    private ArrayList<PlaneGameTerrain> terrainList;
    private int terrainSpawnCount;

    public PlaneGameState(Handler handler) {
        super(handler);
        this.handler = handler;
        planeList = new ArrayList<Plane>();
        terrainList = new ArrayList<>();
        bomber = new Bomber(this.handler, 500, 500, 32, 32);
        planeList.add(new Plane(this.handler, 0, 0, 64, 64));
        planeList.add(new Plane(this.handler, 100, 500, 64, 32));
        planeList.add(new Plane(this.handler, 200, 500, 64, 32));
        terrainList.add(new PlaneGameTerrain(handler, (int) (Math.random() * (handler.getWidth())), 0, 64, 64));
        terrainSpawnCount = 90;
        super.setName("PlaneGameState");
    }

    public void terrainSpawn() {
        terrainSpawnCount++;
        PlaneGameTerrain a,b,c;
        if (terrainSpawnCount > 90) {
           
            a =(new PlaneGameTerrain(handler, (int) (Math.random() * (handler.getWidth())), -50, 64, 64));
            terrainList.add(a);
            if ((int) (Math.random() * 4 + 1) >= 2) {
                b = (new PlaneGameTerrain(handler, (int) (Math.random() * (handler.getWidth())), -50, 64, 64));
                terrainList.add(b);
            }
            if ((int) (Math.random() * 4 + 1) >= 3) {
                c = (new PlaneGameTerrain(handler, (int) (Math.random() * (handler.getWidth())), -50, 64, 64));
                terrainList.add(c);
            }
            terrainSpawnCount = 0;
        }
    }

    @Override
    public void tick() {

        bomber.tick();
        for (int x = 0; x < planeList.size(); x++) {
            planeList.get(x).tick();
        }
        terrainSpawn();
        
        for (PlaneGameTerrain t : terrainList) {
            t.tick();
        }
        
    }

    @Override
    public void render(Graphics g) {
        for (PlaneGameTerrain t : terrainList) {
            t.render(g);
        }
        
        bomber.render(g);
        for (int x = 0; x < planeList.size(); x++) {
            planeList.get(x).render(g);
        }
    }

}
