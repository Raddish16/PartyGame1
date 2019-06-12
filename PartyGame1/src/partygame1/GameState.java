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
public class GameState extends State{
    private SpriteSheet sheet;
    private ArrayList<BufferedImage> testMouse;
    
    public GameState(Game game){
        super(game);
        
        //fills testMouse with sprites from the mouseSheet sprite sheet
        sheet = new SpriteSheet(imageLoader.loadImage("/textures/mouseSheet.png"));
        testMouse = new ArrayList<BufferedImage>();
        for(int y = 0; y<104;y+=26){
            for(int x = 0; x<104;x+=26){
                testMouse.add(sheet.crop(x, y, 26, 26));
            }
        }
    }
    
    
    int testCount = 0;
    public void tick(){
        testCount++;
        if(testCount >477)
            testCount = 0;
    }
    
    public void render(Graphics graph){
        //test image
        graph.drawImage(testMouse.get((int)testCount/30), 300, 300, null);
        
    }
}
