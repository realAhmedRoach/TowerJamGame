package dev.thetechnokid.gather.stages;

import java.awt.Graphics;
import java.util.Random;

import dev.thetechnokid.gather.Game;
import dev.thetechnokid.gather.entities.*;
import dev.thetechnokid.gather.gfx.*;

public class War extends Stage {

	private EntityController controller = Game.getCurrentGame().getScreen().getController();
	private boolean lost;
	private Random random = new Random();

	public War() {
		createEnemies();
	}

	private void createEnemies() {
		for (int y = 0; y < Game.HEIGHT / Tile.DRAW_SIZE; y+=2) {
			boolean rand = random.nextBoolean();
			Enemy enemy = new Enemy(rand);
			enemy.x = random.nextInt(Game.WIDTH - Tile.DRAW_SIZE);
			enemy.y = y * Tile.DRAW_SIZE;
			Game.getCurrentGame().getScreen().getController().addEntity(enemy);
		}
	}

	@Override
	public void render(Graphics g, Screen screen) {

	}

	@Override
	public void tick() {
		if (!controller.getEntities().contains(controller.getUser())) {
			controller.getEntities().clear();
			lost = true;
		}
		boolean enemiesLeft = false;
		for (Entity e : controller.getEntities()) {
			if (e instanceof Enemy)
				enemiesLeft = true;
		}

		if (lost) {
			Stage.setCurrentStage(new After(true));
		} else if (!enemiesLeft) {
			Stage.setCurrentStage(new After(false));
		}
	}

}
