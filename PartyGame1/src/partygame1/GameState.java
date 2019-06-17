/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Yasuki Wu
 */
public class GameState extends State {

    private SpriteSheet sheet;
    private ArrayList<BufferedImage> testMouse;
    private Player Player1;
    private boolean planeGame;
    private State planeGameState;
    private Handler handler;

    public GameState(Handler handler) {
        super(handler);
        //world = new World(game, "res/worlds/world1.txt");
        //handler.setWorld(world);
        Player1 = new Player(handler, 20, 20, 70, 70);
        this.handler = handler;
        planeGameState = new PlaneGameState(this.handler);
        planeGame = true;
        super.setName("gameState");
    }

    int testCount = 0;

    public void tick() {
        if(planeGame){
            planeGameState.tick();
        }
        testCount++;
        Player1.tick();
        if (testCount > 477) {
            testCount = 0;
        }
    }

    public void render(Graphics graph) {
        if(planeGame){
            planeGameState.render(graph);
        }
        Player1.render(graph);
    }

}
