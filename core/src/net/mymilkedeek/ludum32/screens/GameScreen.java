package net.mymilkedeek.ludum32.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import net.mymilkedeek.ludum32.actors.Player;
import net.mymilkedeek.ludum32.input.KeyboardInput;
import net.mymilkedeek.ludum32.utils.Globals;

/**
 * @author Michaël
 */
public class GameScreen extends ScreenAdapter {

    private final String TAG = "net.mymilkedeek.ludum32.screens.GameScreen";

    private Stage stage;
    private Player player;
    private InputMultiplexer inputMultiplexer;

    // ugliness be damned
    private ShapeRenderer shapeRenderer;

    public GameScreen() {
        // empty for now
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.135f, .206f, .235f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.stage.act(delta);
        this.stage.draw();

        if ( player.shot() ) {
            // TODO decide on rotation and which parts to draw
            this.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            this.shapeRenderer.rect(0, 0, 800, 250);
            this.shapeRenderer.end();
        }
    }

    @Override
    public void show() {
        Gdx.app.debug(TAG, "GameScreen show.");

        // stage settings
        this.stage = new Stage(new FitViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT));
        this.player = new Player("player/player.png");
        this.player.setX(384f);
        this.player.setY(227f);
        this.player.setOrigin(16f, 32f);
        this.stage.addActor(this.player);

        // input settings
        this.inputMultiplexer = new InputMultiplexer();
        this.inputMultiplexer.addProcessor(new KeyboardInput(player));
        this.inputMultiplexer.addProcessor(this.stage);
        // of course
        Gdx.input.setInputProcessor(this.inputMultiplexer);

        // shapeRenderer init
        this.shapeRenderer = new ShapeRenderer();
        this.shapeRenderer.setColor(Color.BLACK);
    }
}