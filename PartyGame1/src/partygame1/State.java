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
    protected Game game;
    public static void setState(State state)
    {
        current = state;
    }

    public static State getState()
    {
        return current;
    }

    

    public State(Game game)
    {
        this.game = game;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}
