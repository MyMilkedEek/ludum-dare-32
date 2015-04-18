package net.mymilkedeek.ludum32.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.mymilkedeek.ludum32.GameInstance;

public class DesktopLauncher {
	public static void main (String[] arg) {
		System.setProperty("user.name", "Michael");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new GameInstance(), config);
	}
}
