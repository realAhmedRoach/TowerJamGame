package dev.thetechnokid.gather.stages;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

import dev.thetechnokid.gather.Game;
import dev.thetechnokid.gather.entities.*;
import dev.thetechnokid.gather.gfx.*;

public class War extends Stage {

	private EntityController controller = Game.getCurrentGame().getScreen()
			.getController();
	private boolean lost;
	private Random random = new Random();
	private boolean won;

	public War() {
		createEnemies();
	}

	private void createEnemies() {
		for (int y = 0; y < Game.HEIGHT / Tile.DRAW_SIZE; y++) {
			boolean rand = random.nextBoolean();
			Enemy enemy = new Enemy(rand);
			enemy.x = random.nextInt(Game.WIDTH - Tile.DRAW_SIZE);
			enemy.y = y * Tile.DRAW_SIZE;
			Game.getCurrentGame().getScreen().getController().addEntity(enemy);
		}
	}

	@Override
	public void render(Graphics g, Screen screen) {
		if (lost) {
			Text.render("RIP", g, 10 * Tile.DRAW_SIZE, 8 * Tile.DRAW_SIZE);
			Text.render("1 to continue", g, 8 * Tile.DRAW_SIZE,
					10 * Tile.DRAW_SIZE);
			if (Game.getCurrentGame().getKeyboard().getKeys()[KeyEvent.VK_1]) {
				Stage.setCurrentStage(new After(lost));
			}
		} else if (won) {
			Text.render("1 to continue", g, 8 * Tile.DRAW_SIZE,
					8 * Tile.DRAW_SIZE);
			if (Game.getCurrentGame().getKeyboard().getKeys()[KeyEvent.VK_1]) {
				Stage.setCurrentStage(new After(lost));
			}
		}
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
		if (!enemiesLeft && !lost)
			won = true;
	}

}
