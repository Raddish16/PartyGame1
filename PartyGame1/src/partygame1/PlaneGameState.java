/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Color;
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
        handler.setName("PlaneGameState");
        terrainSpawn();
    }

    public void terrainSpawn() {
        for(int x = 0; x<12; x++){
            terrainList.add(new PlaneGameTerrain(handler, (int)(Math.random()*handler.getWidth()),(int)(Math.random()*handler.getHeight()), 64,64));
        }
        /*PlaneGameTerrain a, b, c;
        if (terrainSpawnCount > 90) {

            a = (new PlaneGameTerrain(handler, (int) (Math.random() * (handler.getWidth())), -50, 64, 64));
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
        }*/
    }

    @Override
    public void tick() {
        
        bomber.tick();
        for (int x = 0; x < planeList.size(); x++) {
            planeList.get(x).tick();
            if(planeList.get(x).getX() < 0 || planeList.get(x).getX() > handler.getWidth() || planeList.get(x).getY() < 0 || planeList.get(x).getY() > handler.getHeight()){
                planeList.remove(x);
            }
        }
        
        for (PlaneGameTerrain t : terrainList) {
            t.tick();
            if(t.getY()>handler.getHeight()+20){
                t.setX((int)(Math.random()*handler.getWidth()));
                t.setY((int)(Math.random()*handler.getHeight()));
            }
        }
        spawn();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(113, 204, 65));
        g.fillRect(0,0,handler.getWidth(),handler.getHeight());
        for (PlaneGameTerrain t : terrainList) {
            t.render(g);
        }

        bomber.render(g);
        for (int x = 0; x < planeList.size(); x++) {
            planeList.get(x).render(g);
        }
    }

    public void spawn() {
        if (Math.random() > .95) {
            if (Math.random() > .5) {
                planeList.add(new Plane(this.handler, 0, (int) (Math.random() * 300), 64, 32));
            }else{
                planeList.add(new Plane(this.handler, 1400, (int) (Math.random() * 300), 64, 32));
            }
        }
        
    }
}
