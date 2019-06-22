/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import com.sun.prism.paint.Color;
import java.awt.Graphics;

/**
 *
 * @author brendanwilhelm
 */
public class Twov1GameState extends State{
    
    private gameCharacter pupMaster;
    private gameCharacter play1, play2;

    public Twov1GameState(Handler handler) {
        super(handler);
        pupMaster = new gameCharacter(handler, handler.getWidth() - 200, handler.getHeight() - 700, 64, 64, "Puppet Master");
        play1 = new gameCharacter(handler, handler.getWidth() + 100, handler.getHeight() - 700, 32, 32, "Fisherman");
        play2 = new gameCharacter(handler, handler.getWidth() + 150, handler.getHeight() - 700, 32, 32, "mower");
        handler.setName("Twov1GameState");
    }

    @Override
    public void tick() {
        pupMaster.tick();
        play1.tick();
        play2.tick();
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(java.awt.Color.blue);
        g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
        g.setColor(java.awt.Color.black);
        g.fillRect(0,handler.getHeight() - 200, handler.getWidth(), 200);
        pupMaster.render(g);
        play1.render(g);
        play2.render(g);
    }
}
