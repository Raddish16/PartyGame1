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
        
    }
    
    
    int testCount = 0;
    public void tick(){
        testCount++;
        if(testCount >477)
            testCount = 0;
    }
    
    public void render(Graphics graph){
        //test image
        graph.drawImage(Assets.mouse.get((int)testCount/30), 300, 300, 400, 400, null);//You can resize the mouse by changing the last two numbers
        
    }
}
