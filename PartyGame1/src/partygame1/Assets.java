/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Yasuki Wu
 */
public class Assets {

    private static final int width = 32, height = 32;
    public static SpriteSheet mouseSheet, startSheet, bomberSheet, planeSheet, bRobotSheet, turretSheet;
    public static ArrayList<BufferedImage> mouse, madmouseR, madmouseL, normouseR, normouseL, bomber, plane, bRobot, greenMonster,turret;//easier to iterate through
    public static BufferedImage[][] mouse2;//easier to reference
    public static BufferedImage[] startBtn;
    public static BufferedImage MenuTitle;

    public static void init() {
        mouseSheet = new SpriteSheet(imageLoader.loadImage("/textures/Mouse updated.png"));
        startSheet = new SpriteSheet(imageLoader.loadImage("/textures/Start Button.png"));
        bomberSheet = new SpriteSheet(imageLoader.loadImage("/textures/miniBomberSheet.png"));
        planeSheet = new SpriteSheet(imageLoader.loadImage("/textures/miniPlaneSheet.png"));
        bRobotSheet = new SpriteSheet(imageLoader.loadImage("/textures/robotSheet.png"));
        turretSheet = new SpriteSheet(imageLoader.loadImage("/textures/miniBomberTurretSheet.png"));
        
        MenuTitle = imageLoader.loadImage("/textures/Menu Title.png");
        
        mouse = new ArrayList<BufferedImage>();
        madmouseR = new ArrayList<BufferedImage>();
        normouseR = new ArrayList<BufferedImage>();
        madmouseL = new ArrayList<BufferedImage>();
        normouseL = new ArrayList<BufferedImage>();
        turret = new ArrayList<>();
        
        greenMonster = new ArrayList<BufferedImage>();
        
        startBtn = new BufferedImage[6];
        for(int x = 0; x < 6; x++){
            startBtn[x] = startSheet.crop(0, 34*x, 130, 32);
        }
        
        for (int y = 0; y < 156; y += 26) {
            for (int x = 0; x < 130; x += 26) {
                mouse.add(mouseSheet.crop(x, y, 26, 26));
            }
        }
        for (int y = 0; y < 8; y++) {
            normouseR.add(mouse.get(y));
        }
        for (int y = 8; y < 14; y++) {
            madmouseR.add(mouse.get(y));
        }
        for (int y = 14; y < 22; y++) {
            normouseL.add(mouse.get(y));
        }
        for (int y = 22; y < 28; y++) {
            madmouseL.add(mouse.get(y));
        }

        //I accidentally repeated the same thing you did
        /*BufferedImage[] mouse1 = new BufferedImage[16];
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                mouse1[4*x + y] = sheet.crop(26*x, 26*y, 26, 26);
            }
        }*/
        
        
        mouse2 = new BufferedImage[4][4];
        for (int c = 0; c < mouse2[0].length; c++) {
            for (int r = 0; r < mouse2.length; r++) {
                mouse2[r][c] = mouseSheet.crop(r * 26, c * 26, 26, 26);
            }
        }
        bomber = new ArrayList<>();
        for (int n = 0; n < 352; n += 32) {
            bomber.add(bomberSheet.crop(0, n, 32, 32));
        }
        plane = new ArrayList<>();
        for (int y = 0; y < 64; y += 32) {
            for (int x = 0; x < 64; x += 32) {
                plane.add(planeSheet.crop(x, y, 32, 32));
            }
        }
        bRobot = new ArrayList<>();
        for(int y = 0; y<96;y+=32){
            for(int x = 0; x<96;x+=32){
                bRobot.add(bRobotSheet.crop(x, y, width, height));
            }
        }for(int y = 0; y<96;y+=32){
            for(int x = 0; x<96;x+=32){
                turret.add(turretSheet.crop(x, y, width, height));
            }
        }
        
    }
    /*public BufferedImage[] retrieve(String charName){
        if(charName.equals("Puppet Master")){
            return;
        }else if(charName.equals("Vigilante")){
            return;
        }else if(charName.equals("Banjo")){
            return;
        }
        return null;
    }*/
}
