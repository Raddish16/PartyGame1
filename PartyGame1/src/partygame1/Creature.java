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
public class Creature extends Entity {

    public static final int defaultHealth = 10;
    public static final float defaultSpeed = 3.0f;
    public static final int defaultWidth = 32;
    public static final int defaultHeight = 32;
    protected int health;
    protected float speed;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = defaultHealth;
        speed = defaultSpeed;
    }

    /*public void move(){
        x += xMove;
        y += yMove;
    }*/
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
