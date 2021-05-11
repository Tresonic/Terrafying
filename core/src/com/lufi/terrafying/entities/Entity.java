package com.lufi.terrafying.entities;

import com.lufi.terrafying.world.Vector2i;

public class Entity {
	public float posx;
	public float posy;
	public float speedx;
	public float speedy;
	public int id;
	
	public String tex;
	public String name;
	
	protected Vector2i lastMoveDir;
	
	public boolean isPlayer;
	
	public Entity() {
		isPlayer = false;
		lastMoveDir = new Vector2i();
	}
	
	public Entity(float x, float y, int ID, String nName) {
		posx = x; posy = y;
		id = ID;
		isPlayer = false;
		name = nName;
		lastMoveDir = new Vector2i();
	}
	
	public void update(float delta) {
		posx += speedx * delta;
		posy += speedy * delta;
		
		if(speedx > 0)
			lastMoveDir.x = 1;
		else if(speedx < 0)
			lastMoveDir.x = -1;
		
	}
	
	public int getLastMoveDirX() {
		return lastMoveDir.x;
	}

	public boolean isPlayer() {
		return isPlayer;
	}
}
