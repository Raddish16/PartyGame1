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
public class MenuState extends State {

    Player Player1;
    
    public MenuState(Handler handler) {
        super(handler);
        Player1 = new Player(handler, 0, 0, 70, 70);
    }

    public void tick() {
        System.out.println(handler.getMouseManager().getMouseX() + "  " + handler.getMouseManager().getMouseY());
        Player1.tick();
    }

    public void render(Graphics graph) {
        Player1.render(graph);
    }
}
