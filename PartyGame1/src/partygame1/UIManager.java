/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partygame1;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author Yasuki Wu
 */
public class UIManager {

    private Handler handler;

    private ArrayList<UIObject> objects;

    public UIManager(Handler handler) {
        this.handler = handler;
        Assets.init();//should solve the UI problem when I put it back together
        objects = new ArrayList<UIObject>();
    }

    public void tick() {
        for (UIObject o : objects) {
            o.tick();
        };
    }

    public void render(Graphics g) {
        for (UIObject o : objects) {
            o.render(g);
        };
    }

    public void onMouseMve(MouseEvent e) {
        for (UIObject o : objects) {
            o.onMouseMove(e);
        };
    }

    public void onMouseRelease(MouseEvent e) {
        for (UIObject o : objects) {
            o.onMouseRelease(e);
        };
    }

    public void addObject(UIObject o) {
        objects.add(o);
    }

    public void removedObject(UIObject o) {
        objects.remove(o);
    }
}
