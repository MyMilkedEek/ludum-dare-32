package net.mymilkedeek.ludum32.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    private float originalOrientation;

    public GameScreen() {
        // empty for now
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.135f, .206f, .235f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.stage.act(delta);
        this.stage.draw();

        if ( this.player.rotationChanged() ) {
            Gdx.app.debug(TAG, "Rotation change : " + this.player.getRotation());
            this.shapeRenderer.rotate(0, 0, 1, this.player.getRotation());
        }

        if ( player.shot() ) {
            // TODO decide on rotation and which parts to draw
            this.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            if ( this.player.shotLeft() ) {
                this.shapeRenderer.rect(-600, -1000, 600, 2000);
            }

            if ( this.player.shotRight() ) {
                this.shapeRenderer.rect(0, -1000, 600, 2000);
            }
            this.shapeRenderer.end();
        }

        if ( this.player.rotationChanged() ) {
            this.shapeRenderer.rotate(0, 0, 1, -1* this.player.getRotation());
            this.player.setRotationChanged(false);
        }

        SpriteBatch batch = (SpriteBatch) this.stage.getBatch();
        batch.begin();
        this.player.draw(batch, 1f);
        batch.end();
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
        Gdx.input.setCursorCatched(true);

        // shapeRenderer init
        this.shapeRenderer = new ShapeRenderer();
        this.shapeRenderer.setColor(Color.BLACK);
        this.shapeRenderer.identity();
        this.shapeRenderer.translate(400f, 250f, 0f);
        this.originalOrientation = 0f;
    }
}