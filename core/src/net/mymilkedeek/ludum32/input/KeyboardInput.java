package net.mymilkedeek.ludum32.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import net.mymilkedeek.ludum32.actors.Player;
import net.mymilkedeek.ludum32.utils.KeyConfig;

/**
 * @author Michaël
 */
public class KeyboardInput extends InputAdapter {

    private Player player;
    private final String TAG = "net.mymilkedeek.ludum32.input.KeyboardInput";

    public KeyboardInput(final Player player) {
        this.player = player;
    }

    @Override
    public boolean keyDown(int keycode) {
        Gdx.app.debug(TAG, "Keyboard input received.");

        switch ( keycode ) {
            case KeyConfig.LEFT:
                Gdx.app.debug(TAG, "Player move left request.");
                player.rotateLeft();
                return true;
            case KeyConfig.UP:
                Gdx.app.debug(TAG, "Player move up request.");
                return true;
            case KeyConfig.RIGHT:
                Gdx.app.debug(TAG, "Player move right request.");
                player.rotateRight();
                return true;
            case KeyConfig.DOWN:
                Gdx.app.debug(TAG, "Player move down request.");
                return true;
        }

        return false;
    }

    // TODO TOGGLE STATES

    @Override
    public boolean keyUp(int keycode) {
        Gdx.app.debug(TAG, "Keyboard input received.");

        switch ( keycode ) {
            case KeyConfig.LEFT:
                Gdx.app.debug(TAG, "Player move left request ended.");
                if ( player.rotationState() > 0 ) {
                    player.cancelRotation();
                }
                return true;
            case KeyConfig.UP:
                Gdx.app.debug(TAG, "Player move up request ended.");
                return true;
            case KeyConfig.RIGHT:
                Gdx.app.debug(TAG, "Player move right request ended.");
                if ( player.rotationState() < 0 ) {
                    player.cancelRotation();
                }
                return true;
            case KeyConfig.DOWN:
                Gdx.app.debug(TAG, "Player move down request ended.");
                return true;
        }

        return false;
    }

    /*
     * Mask half of the screen!
     */
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Gdx.app.debug(TAG, "Mouse click received");

        switch ( button ) {
            case Input.Buttons.LEFT:
                Gdx.app.debug(TAG, "Left mouse click");
                player.shoot(0);
                return true;

            case Input.Buttons.RIGHT:
                Gdx.app.debug(TAG, "Right mouse click");
                player.shoot(1);
                return true;
        }

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        /*int x = screenX;
        int y = Globals.WORLD_HEIGHT - screenY;

        float rotation = MathUtils.radiansToDegrees * MathUtils.atan2(y - player.getY(), x - player.getX());

        rotation -= 90;

        Gdx.app.debug(TAG, "Mouse movement: " + x + ", " + y + ". Rotation: " + rotation);

        player.setRotation(rotation);*/

        return false;
    }
}