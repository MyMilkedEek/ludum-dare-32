package net.mymilkedeek.ludum32;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import net.mymilkedeek.ludum32.screens.GameScreen;

public class GameInstance extends Game {

	private final String TAG = "net.mymilkedeek.ludum32.GameInstance";

	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.debug(TAG, "Game start.");
		setScreen(new GameScreen());
	}
}
