package net.mymilkedeek.ludum32.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;

/**
 * @author Michaël
 */
public class GameScreen extends ScreenAdapter {

    private final String TAG = "net.mymilkedeek.ludum32.screens.GameScreen";

    public GameScreen() {
        // empty for now
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void show() {
        Gdx.app.debug(TAG, "GameScreen show.");
    }
}