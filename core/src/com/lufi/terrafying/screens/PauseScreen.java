package com.lufi.terrafying.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.lufi.terrafying.Terrafying;
import com.lufi.terrafying.net.TerrafyingServer;

public class PauseScreen implements Screen {

	private Terrafying game;
	
	
	private Stage stage;	
	private Table root;
	
	
	public PauseScreen(final Terrafying nGame) {
		game = nGame;
	}
	
	@Override
	public void show() {
		
		stage = new Stage();
		root = new Table(Terrafying.skin);
		
		
		Label titleLabel = new Label("Pause", Terrafying.skin);
		titleLabel.setFontScale(2);
		root.add(titleLabel).spaceBottom(20);
		root.row();
		
		TextButton resumeButton = new TextButton("resume", Terrafying.skin);
		resumeButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(game.gameScreen);			
			}
		});
		root.add(resumeButton).padBottom(10);
		root.row();
		
		TextButton optionsButton = new TextButton("options", Terrafying.skin);
		optionsButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(game.optionsScreen);			
			}
		});
		root.add(optionsButton).padBottom(30);
		root.row();
		
		TextButton exitButton = new TextButton("exit game", Terrafying.skin);
		exitButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				game.gameScreen.client.disconnect();
				TerrafyingServer.the().stop();
				game.setScreen(game.mainMenuScreen);
			}
		});
		root.add(exitButton).padBottom(10);
		root.row();
		
		
		
		
		root.setFillParent(true);
		stage.addActor(root);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		ScreenUtils.clear(0,0,0,1);
		stage.act();
		stage.draw();

		
		}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
