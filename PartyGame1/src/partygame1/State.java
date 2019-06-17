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
public abstract class State {

    private static State current = null;
    protected static String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        handler.setName(name);
    }

    public static void setState(State state) {
        current = state;
    }

    public static State getState() {
        return current;
    }

    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}
