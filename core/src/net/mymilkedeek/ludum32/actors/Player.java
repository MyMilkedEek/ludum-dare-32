package net.mymilkedeek.ludum32.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * @author Michaël
 */
public class Player extends Image {

    private final String TAG = "net.mymilkedeek.ludum32.actors.Player";

    private boolean shotLeft;
    private boolean shotRight;

    public Player(String path) {
        super(new Texture(path));
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