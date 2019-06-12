/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

/**
 *
 * @author brendanwilhelm
 */
public class Handler {

    private Game game;

    // until needed private World world;
    public Handler(Game game) {
        this.game = game;
    }

    public int getWidth() {
        return game.getWidth();
    }

    public int getHeight() {
        return game.getHeight();
    }

    //Until needed
    /*public GameCamera getGameCamera(){
        return game.getGameCamera();
    }*/

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }

    public Game getGame() {
        return game;
    }

    /*public World getWorld(){
        return world;
    }*///until needed
}
