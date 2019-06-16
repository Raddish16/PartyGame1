/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Yasuki Wu
 */
public class PlaneGameTerrain extends Creature{
    private BufferedImage terrain;
    public PlaneGameTerrain(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        this.handler = handler;
        Assets.init();
        terrain = (imageLoader.loadImage("/textures/grass.png"));//temp code
        xMove = 0;
        yMove = 3;
    }
    public void move(){
        super.move();
    }
    public void tick(){
        move();
    }
    public void render(Graphics g){
        g.drawImage(terrain,(int)x,(int)y,width,height,null);
    }
    
    
}
