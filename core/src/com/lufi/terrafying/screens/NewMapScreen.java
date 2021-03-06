package com.lufi.terrafying.screens;

import static com.lufi.terrafying.Terrafying.skin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.lufi.terrafying.Terrafying;
import com.lufi.terrafying.world.LoaderSaver;


public class NewMapScreen implements Screen {
	private Terrafying game;
	
	
	private Stage stage;	
	private Table root;
	
	
	public NewMapScreen(final Terrafying nGame) {
		game = nGame;
		
	}
	
	@Override
	public void show() {
		stage = new Stage();
		root = new Table(skin);
		
		Label titleLabel = new Label("Create a new World", skin);
		titleLabel.setFontScale(2);
		root.add(titleLabel).colspan(2).spaceBottom(20);
		root.row();
		
		Label nameLabel = new Label("name:", skin);
		root.add(nameLabel);
		final TextField nameField = new TextField("", skin);
		root.add(nameField);
		root.row();
		root.add(new Actor()).spaceBottom(20);
		root.row();
		
		Label sizeXLabel = new Label("width in chunks:", skin);
		root.add(sizeXLabel);
		final TextField sizeXField = new TextField("50", skin);
		root.add(sizeXField);
		root.row();
		
		root.add(new Actor()).spaceBottom(10);
		root.row();
		
		Label sizeYLabel = new Label("height in chunks:", skin);
		root.add(sizeYLabel).spaceBottom(30);
		final TextField sizeYField = new TextField("15", skin);
		root.add(sizeYField).spaceBottom(30);
		root.row();
		
		TextButton backButton = new TextButton("back", skin);
		backButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(new MainMenuScreen(game));
			}
		});
		root.add(backButton);
		
		TextButton createButton = new TextButton("create & save", skin);
		createButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				if(!nameField.getText().isEmpty()) {
					LoaderSaver.genAndSaveMap(nameField.getText(), Integer.parseInt(sizeXField.getText()), Integer.parseInt(sizeYField.getText()));
					game.setScreen(new MainMenuScreen(game));
				}
			}
		});
		root.add(createButton);
		
		
		
		root.setFillParent(true);
		stage.addActor(root);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0,0,0,1);
		stage.act();
		stage.draw();
	}
	
	@Override
	public void resize(int x, int y) {
		stage.getViewport().update(x, y, true);
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
