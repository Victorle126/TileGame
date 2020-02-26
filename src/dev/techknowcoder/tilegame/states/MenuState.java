package dev.techknowcoder.tilegame.states;

import dev.techknowcoder.tilegame.Handler;
import dev.techknowcoder.tilegame.gfx.Assets;
import dev.techknowcoder.tilegame.ui.ClickListener;
import dev.techknowcoder.tilegame.ui.UIImageButton;
import dev.techknowcoder.tilegame.ui.UIManager;

import java.awt.Graphics;

public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);

        uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btn_start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();

        // Temporarily just go directly to the GameState, skip the menu state!
        handler.getMouseManager().setUIManager(null);
        State.setState(handler.getGame().gameState);
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }

}
