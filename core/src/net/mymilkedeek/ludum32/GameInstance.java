package net.mymilkedeek.ludum32;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import net.mymilkedeek.ludum32.screens.GameScreen;

public class GameInstance extends Game {
	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		setScreen(new GameScreen());
	}
}
