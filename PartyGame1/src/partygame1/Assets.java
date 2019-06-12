/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Yasuki Wu
 */
public class Assets {
    private static SpriteSheet sheet;
    public static ArrayList<BufferedImage>mouse;
    
    public static void init(){
        sheet = new SpriteSheet(imageLoader.loadImage("/textures/mouseSheet.png"));
        mouse = new ArrayList<BufferedImage>();
        for(int y = 0; y<104;y+=26){
            for(int x = 0; x<104;x+=26){
                mouse.add(sheet.crop(x, y, 26, 26));
            }
        }
    }
    
}
