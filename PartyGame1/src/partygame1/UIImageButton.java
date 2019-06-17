/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

/**
 *
 * @author Yasuki Wu
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {

    private BufferedImage[] images;
    private ClickListener clicker;
    private int count = 0;
    private int image = 0;

    public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
        super(x, y, width, height);
        this.images = images;
        this.clicker = clicker;
    }

    @Override
    public void tick() {
        if(hover){
            count++;
            if(count%20 == 0){
                image++;
            }
            if(image ==6){
                image = 0;
                count = 0;
            }
        }else
            image = 0;
    }

    @Override
    public void render(Graphics g) {
        if (hover) {
                g.drawImage(images[(image)], (int) x, (int) y, width, height, null);
        } else {
            g.drawImage(images[0], (int) x, (int) y, width, height, null);
        }
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }

}
