package gettothecastle.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import gettothecastle.gfx.Tile;
import gettothecastle.input.Keyboard;

public abstract class Entity {
	public int x, y;
	protected Tile tile;
	protected Keyboard handler;

	protected boolean nextSprite = false;
	protected long lastTime;

	public Entity(Tile tile, Keyboard handler) {
		this.tile = tile;
		this.handler = handler;
		lastTime = System.currentTimeMillis();
	}

	public void render(Graphics g) {
		g.drawImage(tile.getImage(), x, y, Tile.DRAW_SIZE, Tile.DRAW_SIZE,
				null);
	}

	public Rectangle bounds() {
		return new Rectangle(x, y, Tile.DRAW_SIZE, Tile.DRAW_SIZE);
	}

	public abstract void tick();
}
