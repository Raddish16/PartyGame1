/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Graphics;

/**
 *
 * @author Yasuki Wu
 */
public class PlaneGameState extends State{
    private Handler handler;
    private Bomber bomber;
    
    public PlaneGameState(Handler handler){
        super(handler);
        this.handler = handler;
        bomber = new Bomber(this.handler,500,500,32,32);
    }

    @Override
    public void tick() {
        bomber.tick();
    }

    @Override
    public void render(Graphics g) {
        bomber.render(g);
    }
        
}
