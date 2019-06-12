/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Yasuki Wu
 */
public class GameState extends State{
    private BufferedImage image;
    public GameState(Game game){
        super(game);
        image =  imageLoader.loadImage("/textures/New Piskel-2.png");
    }
    public void tick(){
        
        
    }

    public void render(Graphics graph){
        //test image
        graph.drawImage(image, 300, 300, null);
        
    }
}
