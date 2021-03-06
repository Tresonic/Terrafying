package com.lufi.terrafying.gui;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.lufi.terrafying.gui.InventoryGui.InvAction;
import com.lufi.terrafying.screens.GameScreen;
import com.lufi.terrafying.util.Vector2i;

public class GuiManager implements InputProcessor {
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	public Vector2 resolution;
	
	public static Color backColor = Color.GRAY;
	public static Color frontColor = Color.LIGHT_GRAY;
	public static Color selectColor = Color.RED;
	
	public static final float HUD_SCALE = 3;
	public static final int MARGIN = 3;
	public static final float SCALED_MARGIN = MARGIN * HUD_SCALE;
	
	private GameScreen gameScreen; 
	BaseGui currentGui;
	private Hotbar hotbar;
	
	private Vector2i spos; // screen position
	private Vector2i mpos; // screen position, unprojected by hudCamera
	private Vector2 wpos; // world position, unprojected by camera
	
	Vector2 currentMetaPos;
	
	boolean guiActive;
	InventoryGui invGui;

	
	
	public GuiManager(GameScreen nGameScreen) {
		gameScreen = nGameScreen;
		guiActive = false;
		hotbar = new Hotbar(gameScreen.world.player.inventory, 9);
		mpos = new Vector2i();
		spos = new Vector2i();
		wpos = new Vector2();
		currentMetaPos = new Vector2();
		resolution = new Vector2(1280, 720);
		invGui = new InventoryGui(gameScreen.world.player.inventory, gameScreen.world.player, gameScreen.world.map);
	}
	
	public void draw(SpriteBatch sb, ShapeRenderer sr, float delta) {	
		updateMouseWpos();
		hotbar.update(wpos, mpos, this, gameScreen.world.entityManager, gameScreen.world.map, gameScreen.client, gameScreen.world.player, gameScreen.game.options);
				
		if(guiActive && currentGui != null)
			currentGui.draw(sb, sr, delta);
		else
			hotbar.draw(sb, sr, gameScreen, delta);
	}
	
	public void updateMouseWpos() {
		Vector3 uVec = new Vector3(spos.x, spos.y, 0);
		if(!gameScreen.camera.unproject(uVec).equals(wpos)) {
			mouseMoved(spos.x, spos.y);
		}
	}
	

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == gameScreen.game.options.getKeyInv()) {
			if(guiActive) {
				currentGui = null;
				invGui.invAction = InvAction.CRAFT;
				if(invGui.metaDirty) {
					gameScreen.client.sendMetaUpdate(currentMetaPos.x, currentMetaPos.y);
					invGui.metaDirty = false;
				}
				gameScreen.world.map.setMetaLockAt(currentMetaPos, false);
				gameScreen.client.sendMetaLock(currentMetaPos.x, currentMetaPos.y, false);
			}
			else {
				currentGui = invGui;
				invGui.updateCraftGui();
			}
			guiActive = !guiActive;
		} else if(guiActive) {
			currentGui.keyDown(keycode);
		} else if(keycode >= Keys.NUM_1 && keycode <= Keys.NUM_9) {
			hotbar.keyDown(keycode);
		} else if(keycode == Keys.ESCAPE) {
			gameScreen.game.setScreen(gameScreen.game.pauseScreen);
		} else {
			gameScreen.world.player.keyDown(keycode);
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		gameScreen.world.player.keyUp(keycode);
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		mouseMoved(screenX, screenY);
		if(!guiActive) {
			hotbar.mouseDown((int)wpos.x, (int)wpos.y, button);
			// Vector3 wpos = gameScreen.camera.unproject(new Vector3(screenX, screenY, 0));
//			if(button == Input.Buttons.LEFT)
//				gameScreen.world.map.setBlockAt(wpos.x, wpos.y, Block.getBlockByName("air").getId());

		} else {
			currentGui.mouseDown((int)mpos.x, (int)mpos.y, button);
		}
			
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		mouseMoved(screenX, screenY);
		if(!guiActive) {
			hotbar.mouseUp((int)mpos.x, (int)mpos.y, button);
		}
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		mouseMoved(screenX, screenY);
		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		spos.set(screenX, screenY);
		Vector3 uVec = new Vector3(screenX, screenY, 0);
		gameScreen.hudCamera.unproject(uVec);
		mpos.set((int)uVec.x, (int)uVec.y);
		uVec.set(screenX, screenY, 0);
		gameScreen.camera.unproject(uVec);
		wpos.set(uVec.x, uVec.y);
	
		if(!guiActive) {
			hotbar.mouseMoved((int)wpos.x, (int)wpos.y);
		} else {
			currentGui.mouseMoved((int)mpos.x, (int)mpos.y);
		}
		return true;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
//		resolution.x += resolution.x * 0.3f * Math.signum(amountY);
//		resolution.y += resolution.y * 0.3f * Math.signum(amountY);
//		resolution.x = MathUtils.clamp(resolution.x, 426, 1280);
//		resolution.y = MathUtils.clamp(resolution.y, 240, 720);
//		gameScreen.camera.viewportWidth = resolution.x;
//		gameScreen.camera.viewportHeight = resolution.y;
//		gameScreen.camera.update();
		if(!guiActive) {
			hotbar.scrolled(amountY);
		}

		return true;
	}

}
