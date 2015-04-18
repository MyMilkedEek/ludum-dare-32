package net.mymilkedeek.ludum32.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * @author Michaël
 */
public class Player extends Image {

    private final String TAG = "net.mymilkedeek.ludum32.actors.Player";

    private float leftCounter;
    private float rightCounter;

    private int rotationState = 0;


    private boolean rotationChanged;
    private float rotationChange;

    public Player(String path) {
        super(new Texture(path));
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if ( rotationState != 0) {
            super.rotateBy(rotationState);
            this.setRotationChanged(true);
        }

        Gdx.app.debug(TAG, delta + " delta");

        if ( leftCounter > 0 ) {
            Gdx.app.debug(TAG, leftCounter + " lc");
            leftCounter-=delta;
        }

        if ( rightCounter > 0 ) {
            rightCounter -= delta;
        }
    }

    public void shoot(int i) {
        if ( i == 0 ) {
            leftCounter = 1.0f;
        } else {
            rightCounter = 1.0f;
        }
    }

    @Override
    public void setRotation(float degrees) {
        this.rotationChange = super.getRotation() - degrees;
        super.setRotation(degrees);
        this.rotationChanged = true;
    }

    public boolean shot() {
        return shotRight() || shotLeft();
    }

    public boolean rotationChanged() {
        return this.rotationChanged;
    }

    public void setRotationChanged(boolean rotationChanged) {
        this.rotationChanged = rotationChanged;
    }

    public float getRotationChange() {
        return rotationChange;
    }

    public boolean shotLeft() {
        return leftCounter > 0;
    }

    public boolean shotRight() {
        return rightCounter > 0;
    }

    public void rotateLeft() {
        if ( rotationState != 0 ) {
            return;
        }

        rotationState = 3;
    }

    public void rotateRight() {
        if ( rotationState != 0 ) {
            return;
        }

        rotationState = -3;
    }

    public void cancelRotation() {
        rotationState = 0;
    }

    public int rotationState() {
        return rotationState;
    }
}