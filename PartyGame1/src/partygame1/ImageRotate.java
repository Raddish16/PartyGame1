/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Yasuki Wu
 */
public class ImageRotate {
    public static BufferedImage rotate(double degrees, BufferedImage I){
       return null;
    }
    public static BufferedImage newRotateImage(double degrees, BufferedImage I) {
        BufferedImage newI = new BufferedImage(I.getWidth(), I.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) newI.getGraphics();
        g2.rotate(Math.toRadians(degrees), I.getWidth() / 2, I.getHeight() / 2);
        g2.drawImage(I, 0, 0, null);
        return newI;
    }
}
