package dev.thetechnokid.gather.stages;

import java.awt.Graphics;
import java.util.Random;

import dev.thetechnokid.gather.Game;
import dev.thetechnokid.gather.entities.Enemy;
import dev.thetechnokid.gather.entities.EntityController;
import dev.thetechnokid.gather.gfx.*;

public class War extends Stage {

	private EntityController controller = Game.getCurrentGame().getScreen().getController();
	private boolean lost;
	private Random random = new Random();
	
	public War() {
		createEnemies();
	}

	private void createEnemies() {
		for(int y = 0; y < Game.HEIGHT / Tile.DRAW_SIZE; y++) {
			boolean rand = random.nextBoolean();
			Enemy enemy = new Enemy(rand);
			enemy.x = random.nextInt(Game.WIDTH-Tile.DRAW_SIZE);
			enemy.y = y * Tile.DRAW_SIZE;
			Game.getCurrentGame().getScreen().getController().addEntity(enemy);
		}
	}

	@Override
	public void render(Graphics g, Screen screen) {
		if(lost) 
			Text.render("RIP", g, 10*Tile.DRAW_SIZE, 8*Tile.DRAW_SIZE);
	}

	@Override
	public void tick() {
		if(!controller.getEntities().contains(controller.getUser())) {
			controller.getEntities().clear();
			lost = true;
		}
	}

}
