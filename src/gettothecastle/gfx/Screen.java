package gettothecastle.gfx;

import java.awt.Graphics;
import java.util.Random;

import gettothecastle.Game;
import gettothecastle.entities.EntityController;
import gettothecastle.entities.Ore;
import gettothecastle.stages.Menu;
import gettothecastle.stages.Stage;

public class Screen {
	public final int width, height;

	public static final int MAP_SIZE = 8;

	private Map map;
	private EntityController ec;

	private Random rand = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		map = new Map(this);
		ec = new EntityController();

		addEntities();

		Stage.setCurrentStage(new Menu());
	}

	private void addEntities() {
		for (int y = 0; y < height / Tile.DRAW_SIZE; y++) {
			for (int x = 0; x < width / Tile.DRAW_SIZE; x++) {
				if (rand.nextInt(6) == 5) {
					Ore c = new Ore(Game.getCurrentGame().getKeyboard());
					c.x = x * Tile.DRAW_SIZE;
					c.y = y * Tile.DRAW_SIZE;
					ec.addEntity(c);
				}
			}
		}
	}

	public Map getMap() {
		return map;
	}

	public EntityController getController() {
		return ec;
	}

	public void tick() {
		map.tick();
		ec.tick();
	}

	public void render(Graphics g) {
		map.render(g);
		ec.render(g);
	}
}
