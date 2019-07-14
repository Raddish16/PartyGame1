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
    private ArrayList<Bomber> bombers;
    private ArrayList<Plane> planeList;
    private ArrayList<PlaneGameTerrain> terrainList;
    public static ArrayList<Bullet> bullets,enemyBullets;
    private int planeNumber, p1Score;//will hold the number of planes onscreen, will be scaled with time
    private ArrayList<Integer>scores;
    public PlaneGameState(Handler handler) {
        super(handler);
        this.handler = handler;
        planeNumber = 5;
        planeList = new ArrayList<Plane>();
        terrainList = new ArrayList<>();
        bombers = new ArrayList<>();
        bullets = new ArrayList<>();
        enemyBullets = new ArrayList<>();
        
        bombers.add(new Bomber(this.handler, 500, 500, 64, 64));

        terrainList.add(new PlaneGameTerrain(handler, (int) (Math.random() * (handler.getWidth())), 0, 64, 64));
        handler.setName("PlaneGameState");
        terrainSpawn();
        spawn();

    }

    public void terrainSpawn() {
        for (int x = 0; x < 12; x++) {
            terrainList.add(new PlaneGameTerrain(handler, (int) (Math.random() * handler.getWidth()), (int) (Math.random() * handler.getHeight()), 64, 64));
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
        for (Bomber b : bombers) {
            b.tick();
        }
        for (Bullet b : bullets) {
            b.tick();
        }
        for (Bullet b : enemyBullets) {
            b.tick();
        }

        for (PlaneGameTerrain t : terrainList) {
            t.tick();
            if (t.getY() > handler.getHeight() + 20) {
                t.setX((int) (Math.random() * handler.getWidth()));
                t.setY(-50);
            }
        }
        for (Plane p : planeList) {

            p.tick();
            if (p.getY() > handler.getHeight() + 20 || p.getY() < -50 || p.getX() > handler.getWidth() + 20 || p.getX() < -50) {
                p.setX((int) (Math.random() * handler.getWidth()));
                p.setY(-30);
                p.resetCount();
                p.setDeath(false);
                System.out.println("respawning plane enemy");
            }

        }
        //checks for hits on enemt planes, increases scores and destroys enemies
        for (Plane p : planeList) {
            for (Bullet b : bullets) {
                if (p.getBounds().intersects(b.getBounds())) {
                    if(!p.getDeath())
                        p1Score++;
                    p.setDeath(true);
                    System.out.println("hit");
                    
                    
                }
            }
        }
        //does same but for player hit detection
        for(Bomber b :bombers){
           for(Bullet bu: enemyBullets){
               if(b.getBounds().intersects(bu.getBounds()))
                   if(!b.getInvuln()){
                       b.loseHealth();
                       b.setInvuln(true);
                   }
           }
        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(113, 204, 65));
        g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
        
        for (PlaneGameTerrain t : terrainList) {
            t.render(g);
        }
        for (Bomber b : bombers) {
            b.render(g);
        }
        for (Bullet b : bullets) {
            b.render(g);
        }
        for (Bullet b : enemyBullets) {
            b.render(g);
        }
        for (Plane p : planeList) {
            p.render(g);
        }
        g.drawString("P1 Score: "+p1Score, 50, 25);//displays p1 score
    }

    public void spawn() {
        for (int x = 0; x < planeNumber; x++) {
            if (Math.random() > .5) {
                planeList.add(new Plane(this.handler, (int)(Math.random() * handler.getWidth()), (int) (Math.random() * handler.getHeight()), 64, 64));
            } else {
                planeList.add(new Plane(this.handler, (int)(Math.random() * handler.getWidth()), (int) (Math.random() * handler.getHeight()), 64, 64));
            }

        }
    }
}
