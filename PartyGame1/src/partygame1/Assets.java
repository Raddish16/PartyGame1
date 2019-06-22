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
    public static SpriteSheet mouseSheet, startSheet, bomberSheet, planeSheet, bRobotSheet, turretSheet, pupSheet, mowSheet, fishSheet;
    public static ArrayList<BufferedImage> mouse, madmouseR, madmouseL, normouseR, normouseL, bomber, plane, bRobot, greenMonster, turret, puppet, mower, fisher;//easier to iterate through

    
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

        pupSheet = new SpriteSheet(imageLoader.loadImage("/textures/Puppet Master.png"));
        mowSheet = new SpriteSheet(imageLoader.loadImage("/textures/Matt the Mower King.png"));
        fishSheet = new SpriteSheet(imageLoader.loadImage("/textures/Fisherman Frank.png"));

        MenuTitle = imageLoader.loadImage("/textures/Menu Title.png");

        mouse = new ArrayList<BufferedImage>();
        madmouseR = new ArrayList<BufferedImage>();
        normouseR = new ArrayList<BufferedImage>();
        madmouseL = new ArrayList<BufferedImage>();
        normouseL = new ArrayList<BufferedImage>();

        turret = new ArrayList<>();

        puppet = new ArrayList<BufferedImage>();
        mower = new ArrayList<BufferedImage>();
        fisher = new ArrayList<BufferedImage>();

        greenMonster = new ArrayList<BufferedImage>();

        startBtn = new BufferedImage[6];

        for (int x = 0; x < 6; x++) {
            startBtn[x] = startSheet.crop(0, 34 * x, 130, 32);
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

        for (int y = 0; y < 12; y++) {
            fisher.add(fishSheet.crop(0, y * 50, 50, 50));
        }
        for (int y = 0; y < 864 / 32; y++) {
            mower.add(mowSheet.crop(0, y * 32, 32, 32));
        }
        for (int y = 0; y < 5; y++) {
            puppet.add(pupSheet.crop(0, y * 96, 32, 96));
        }

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
        for (int y = 0; y < 96; y += 32) {
            for (int x = 0; x < 96; x += 32) {
                bRobot.add(bRobotSheet.crop(x, y, width, height));
            }
        }
        for (int y = 0; y < 96; y += 32) {
            for (int x = 0; x < 96; x += 32) {
                turret.add(turretSheet.crop(x, y, width, height));
            }
        }
    }

    public static ArrayList<BufferedImage> getPuppet() {
        return puppet;//these probably arent needed if you are just trying to acess the arraylist, could just do Assets.puppet instead
    }

    public static ArrayList<BufferedImage> getMower() {
        return mower;
    }
    
    public static ArrayList<BufferedImage> getFisher() {
        return fisher;
    }
}
