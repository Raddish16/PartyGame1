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

    private Player Player1;
    private UIManager uiManager;
    private int aniLoop;
    

    

    public MenuState(Handler handler) {
        super(handler);
        Player1 = new Player(handler, 0, 0, 70, 70);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
        uiManager.addObject(new UIImageButton(handler.getWidth() / 2 - 64, handler.getHeight() / 2 - 64, 128, 128, Assets.startBtn, new ClickListener() {
            @Override
            public void onClick() {
                State.setState(handler.getGame().gameState);
                State.setName("gameState");
            }
        }));
        super.setName("menuState");
    }

    public void tick() {
        System.out.println(handler.getMouseManager().getMouseX() + "  " + handler.getMouseManager().getMouseY());

        uiManager.tick();
        Player1.tick();
    }

    public void render(Graphics graph) {
        graph.drawImage(Assets.MenuTitle, 75, 100, 512 * 3, 32 * 3, null);
        uiManager.render(graph);
        Player1.render(graph);
    }
    
}
