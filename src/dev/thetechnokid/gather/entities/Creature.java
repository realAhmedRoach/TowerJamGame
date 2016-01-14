package dev.thetechnokid.gather.entities;

import dev.thetechnokid.gather.gfx.Tile;

public abstract class Creature extends Entity {

	protected int hp = 100;
	protected int dmg = 5;
	
	protected int frame;
	
	
	public Creature(Tile tile) {
		super(tile);
	}
	
	protected void checkAnim() {
		if(System.currentTimeMillis()-lastTime >= 200) {
			if(frame == 1) frame=2;
			else frame = 1;
			lastTime = System.currentTimeMillis();
		}
	}
	
	protected void hit(int damage) {
		if(hp>=damage) {
			hp -= damage;
		}
		else destroyed = true;
	}

}
