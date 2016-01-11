package dev.thetechnokid.gather.stages;

import java.awt.Graphics;
import java.util.Random;

import dev.thetechnokid.gather.Game;
import dev.thetechnokid.gather.entities.Entity;
import dev.thetechnokid.gather.entities.Ore;
import dev.thetechnokid.gather.entities.Player;
import dev.thetechnokid.gather.entities.Tower;
import dev.thetechnokid.gather.gfx.Screen;
import dev.thetechnokid.gather.gfx.Text;
import dev.thetechnokid.gather.gfx.Tile;
import dev.thetechnokid.gather.util.Countdown;

public class Gameplay extends Stage {

	private Countdown c;
	
	public Gameplay() {
		createEntities();
		c = new Countdown(60);
		c.start();
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
		Text.render(Integer.toString(c.timeLeft()), g, 11*Tile.DRAW_SIZE, 0);
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
		
		if(c.isDone()) {
			Stage.setCurrentStage(new TowerStage());
		}
	}

}
