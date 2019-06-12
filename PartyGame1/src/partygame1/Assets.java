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
    public static ArrayList<BufferedImage>mouse;//easier to iterate through
    public static BufferedImage[][]mouse2;//easier to reference
    public static void init(){
        sheet = new SpriteSheet(imageLoader.loadImage("/textures/mouseSheet.png"));
        mouse = new ArrayList<BufferedImage>();
        for(int y = 0; y<104;y+=26){
            for(int x = 0; x<104;x+=26){
                mouse.add(sheet.crop(x, y, 26, 26));
            }
        }
        mouse2 = new BufferedImage[4][4];
        for(int c = 0; c<mouse2[0].length;c++){
            for(int r = 0; r<mouse2.length;r++){
                mouse2[r][c] = sheet.crop(r*26, c*26, 26, 26);
            }
        }
    }
    
}
