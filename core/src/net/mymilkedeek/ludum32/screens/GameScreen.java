package net.mymilkedeek.ludum32.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;

/**
 * 18/04/2015 - 10:49
 *
 * @author Michaël
 */
public class GameScreen extends ScreenAdapter {

    public GameScreen() {
        // empty for now
    }


    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void show() {
        Gdx.app.debug("MME", "GameScreen show.");
    }
}