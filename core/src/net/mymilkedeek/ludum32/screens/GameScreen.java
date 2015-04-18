package net.mymilkedeek.ludum32.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import net.mymilkedeek.ludum32.actors.Player;
import net.mymilkedeek.ludum32.utils.Globals;

/**
 * @author Michaël
 */
public class GameScreen extends ScreenAdapter {

    private final String TAG = "net.mymilkedeek.ludum32.screens.GameScreen";

    private Stage stage;
    private Player player;

    public GameScreen() {
        // empty for now
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void show() {
        Gdx.app.debug(TAG, "GameScreen show.");
        this.stage = new Stage(new FitViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT));

        this.player = new Player(50f, 50f);

        this.stage.addActor(this.player);
    }
}