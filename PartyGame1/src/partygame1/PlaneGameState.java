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
    private Plane p1,p2,p3;
    
    public PlaneGameState(Handler handler){
        super(handler);
        this.handler = handler;
        bomber = new Bomber(this.handler,500,500,32,32);
        p1 = new Plane(this.handler,200,500,64,64);
        p2 = new Plane(this.handler,400,500,64,32);
        p3 = new Plane(this.handler,600,500,64,32);
    }

    @Override
    public void tick() {
        bomber.tick();
        p1.tick();
        p2.tick();
        p3.tick();
    }

    @Override
    public void render(Graphics g) {
        bomber.render(g);
        p1.render(g);
        p2.render(g);
        p3.render(g);
    }
        
}
