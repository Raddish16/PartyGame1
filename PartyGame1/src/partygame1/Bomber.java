/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Yasuki Wu
 */
public class Bomber extends Creature {
    private Animation dmg1,dmg2,dmg3,dmg4,destroyed;
    private Handler handler;
    private int health, rotated, modX, modY, tickCount;
    private BufferedImage cS, newCs, currentTurret;
    private ArrayList<Bullet> turretBullets;
    private Rectangle bounds;
    private boolean invuln;

    public Bomber(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        speed = 4.5f;
        health = 5;
        this.handler = handler;
        bounds = new Rectangle((int)x,(int)y+15,width,height-45);
        
        invuln = false;
        
        //animations
        ArrayList<BufferedImage>d1 = new ArrayList<BufferedImage>(Assets.bomber.subList(1, 3));
        dmg1 = new Animation(500, d1);
        
        xMove = 0;
        yMove = 0;
        rotated = 0;
        modX = 0;
        modY = -5;
        tickCount = 60;
        Assets.init();
        cS = Assets.bomber.get(0);
        turretBullets = new ArrayList<>();
        currentTurret = Assets.turret.get(4);
    }

    public void rotateImage(double degrees) {
        BufferedImage newI = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) newI.getGraphics();
        g2.rotate(Math.toRadians(degrees), width / 2, height / 2);
        g2.drawImage(cS, 0, 0, null);
        cS = newI;
        g2.dispose();
    }

    public BufferedImage newRotateImage(double degrees) {
        BufferedImage newI = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) newI.getGraphics();
        g2.rotate(Math.toRadians(degrees), width / 2, height / 2);
        g2.drawImage(cS, 0, 0, null);
        newCs = newI;
        return newCs;
    }

    public void getInput() {
        yMove = 0;
        xMove = 0;
        AffineTransform at = new AffineTransform();
        // The angle of the rotation in radians
        double rads = Math.toRadians(-1);
        at.rotate(rads, x, y);
        if (handler.getKeyManager().up) {
            yMove = (-1) * speed;
        }
        if (handler.getKeyManager().left) {
            xMove = (-1) * speed;
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
        }
        if (handler.getKeyManager().down) {
            yMove = speed / 2;
        }
        if (handler.getKeyManager().space) {
            if(tickCount<5)
                currentTurret = Assets.turret.get(0);
            else
                currentTurret = Assets.turret.get(4);
            if(tickCount>10){
                Bullet b = new Bullet(handler, (int)x, (int)y, 64, 64);
                b.setxMove(modX);
                b.setyMove(modY);
                PlaneGameState.bullets.add(b);
                turretBullets.add(b);
                tickCount = 0;
                currentTurret = Assets.turret.get(4);
                
            }
            
        }else
            currentTurret = Assets.turret.get(4);
        
                   
            /*if (handler.getKeyManager().left) {
            rotated -= 1;
            newCs = newRotateImage(rotated);
            if (yMove <= 0) {
                //2nd quadrant
                if (xMove <= 0) {
                    xMove -= 0.05;
                    yMove += 0.05;
                }
                //1st quadrant
                if (xMove >= 0) {
                    xMove -= 0.05;
                    yMove -= 0.05;
                }
            }
            if (yMove >= 0) {
                // 3rd quadrant
                if (xMove <= 0) {
                    xMove += 0.05;
                    yMove += 0.05;
                }
                // 4th quadrant
                if (xMove >= 0) {
                    xMove += 0.05;
                    yMove -= 0.05;
                }
            }
        }
        if (handler.getKeyManager().right) {
            rotated += 1;
            newCs = newRotateImage(rotated);
            if (yMove <= 0) {
                //2nd quadrant
                if (xMove <= 0) {
                    xMove += 0.05;
                    yMove -= 0.05;
                }
                //1st quadrant
                if (xMove >= 0 * speed) {
                    xMove += 0.05;
                    yMove += 0.05;
                }
            }
            if (yMove >= 0) {
                // 3rd quadrant
                if (xMove <= 0) {
                    xMove -= 0.05;
                    yMove -= 0.05;
                }
                // 4th quadrant
                if (xMove >= 0) {
                    xMove -= 0.05;
                    yMove += 0.05;
                }
            }

        }
         */ {
            
        }
    }
    
    public ArrayList<Bullet> getBullets(){
        return turretBullets;
    }
    
    public Rectangle getBounds(){
        return bounds;
    }
    
    public void setInvuln(boolean i){
        invuln = i;
    }
    public boolean getInvuln(){
        return invuln;
    }
    public void move() {
        super.move();
    }
    public void loseHealth(){
        health--;
    }

    public void tick() {
        tickCount++;
        getInput();
        move();
        dmg1.tick();
        if(health == 4){
            cS = dmg1.getCurrentFrame();
        }
        
        //unused code i think
        if (xMove == 0 && yMove == (-1) * speed) {
            newCs = cS;
            rotated = 0;
        }
        if (xMove == 0 && yMove == speed) {
            newCs = newRotateImage(180);
            rotated = 180;
        }
        if (xMove == 0 && yMove == (-1) * speed) {
            newCs = cS;
        }
        if (xMove == 0 && yMove == (-1) * speed) {
            newCs = cS;
        }
       // for (Bullet b : turretBullets) {
       //     b.tick();
        //}
    }

    public void render(Graphics g) {
        
        g.drawImage(cS, (int) x, (int) y, width, height, null);
        g.drawImage(currentTurret, (int) x, (int) y, width, height, null);
        g.setColor(Color.black);
        g.drawRect((int)x,(int)y+15,width,height-45);
        
       // for (Bullet b : turretBullets) {
         //   b.render(g);
         //}
    }

}
