package dev.thetechnokid.gather.stages;

import java.awt.Graphics;
import java.util.Random;

import dev.thetechnokid.gather.Game;
import dev.thetechnokid.gather.entities.*;
import dev.thetechnokid.gather.gfx.Screen;
import dev.thetechnokid.gather.gfx.Tile;

public class Gameplay extends Stage {

	public Gameplay() {
		createEntities();
	}

	private void createEntities() {
		for (int y = 0; y < Game.getCurrentGame().getScreen().height
				/ Tile.DRAW_SIZE; y++) {
			for (int x = 0; x < Game.getCurrentGame().getScreen().width
					/ Tile.DRAW_SIZE; x++) {
				if (new Random().nextInt(6) == 5) {
					Ore c = new Ore();
					c.x = x * Tile.DRAW_SIZE;
					c.y = y * Tile.DRAW_SIZE;
					Game.getCurrentGame().getScreen().getController()
							.addEntity(c);
				}
			}
		}
	}

	@Override
	public void render(Graphics g, Screen screen) {
		Tower t = new Tower();
		t.x = 11*Tile.DRAW_SIZE;
		t.y = Tile.DRAW_SIZE;
		t.render(g);
	}

	@Override
	public void tick() {
		boolean done = false;
		for (Entity entity : Game.getCurrentGame().getScreen().getController()
				.getEntities()) {
			if (!(entity instanceof Player)) {
				Ore o = (Ore) entity;
				if (!o.isMined()) {
					done = false;
					return;
				} else {
					done = true;
				}
			}
		} if (done) {
			for (Entity e : Game.getCurrentGame().getScreen().getController()
					.getEntities()) {
				if(!(e instanceof Player))
					Game.getCurrentGame().getScreen().getController().getEntities()
						.remove(e);
			}
			createEntities();
		}
	}

}
