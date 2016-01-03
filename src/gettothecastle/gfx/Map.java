package gettothecastle.gfx;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import gettothecastle.entities.Entity;

public class Map {
	private HashMap<Point, Tile> tiles = new HashMap<Point, Tile>();
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	private Screen screen;
	
	Random rand = new Random();

	public Map(Screen screen) {
		this.screen = screen;
		generateTiles();
	}

	private void generateTiles() {
		for (int y = 0; y < screen.height / Tile.DRAW_SIZE; y++) {
			for (int x = 0; x < screen.width / Tile.DRAW_SIZE; x++) {
				drawMenu(x, y);
			}
		}
	}

	private void drawMenu(int x, int y) {
		Point p = new Point(x * Tile.DRAW_SIZE, y * Tile.DRAW_SIZE);
		if (rand.nextInt(5)>3) tiles.put(p, Tile.COAL);
		else tiles.put(p, Tile.GRASS);
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

	public void tick() {
		for (Entity entity : entities) {
			entity.tick();
		}
	}

	public void render(Graphics g) {
		for (Point p : tiles.keySet()) {
			g.drawImage(tiles.get(p).getImage(), p.x, p.y, Tile.DRAW_SIZE,
					Tile.DRAW_SIZE, null);
		}
		for (Entity entity : entities) {
			entity.render(g);
		}
	}
}
