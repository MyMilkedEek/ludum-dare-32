package net.mymilkedeek.ludum32.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author Michaël
 */
public class Player extends Actor {

    private final String TAG = "net.mymilkedeek.ludum32.actors.Player";

    private final Texture image;

    private boolean shotLeft;
    private boolean shotRight;

    public Player(final float initialX, final float initialY) {
        this.image = new Texture("player/test.png");

        super.setX(initialX);
        super.setY(initialY);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(image, super.getX(), super.getY());


    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void shoot(int i) {
        if ( i == 0 ) {
            this.shotLeft = true;
        } else {
            this.shotRight = true;
        }
    }

    public boolean shot() {
        return shotRight || shotLeft;
    }
}