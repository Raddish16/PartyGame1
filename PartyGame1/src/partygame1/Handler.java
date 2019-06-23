/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.util.ArrayList;

/**
 *
 * @author brendanwilhelm
 */
public class Handler {

    private Game game;
    private String stateName = "";
    private String play1, play2;
    private ArrayList<gameCharacter> charList;
    
    public Handler(Game game) {
        this.game = game;
        charList = new ArrayList<gameCharacter>();
    }

    public ArrayList<gameCharacter> getCharList() {
        return charList;
    }

    public void addChar(gameCharacter newChar) {
        charList.add(newChar);
    }

    public String getPlay1Name() {
        return play1;
    }

    public void setPlay1Name(String play1) {
        this.play1 = play1;
    }

    public String getPlay2Name() {
        return play2;
    }

    public void setPlay2Name(String play2) {
        this.play2 = play2;
    }

    // until needed private World world;
    

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
    public void setName(String name){
        stateName = name;
        
    }
    public String getName(){
        return stateName;
    }
}
