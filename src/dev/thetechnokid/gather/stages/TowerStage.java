package dev.thetechnokid.gather.stages;

import java.awt.Graphics;

import dev.thetechnokid.gather.entities.Tower;
import dev.thetechnokid.gather.gfx.Screen;
import dev.thetechnokid.gather.gfx.Tile;

public class TowerStage extends Stage {

	Tower t = new Tower();
	
	public TowerStage() {
		t.x = 11*Tile.DRAW_SIZE;
		t.y = Tile.DRAW_SIZE;
	}

	@Override
	public void render(Graphics g, Screen screen) {
		t.render(g);
	}

	@Override
	public void tick() {
	}

}
