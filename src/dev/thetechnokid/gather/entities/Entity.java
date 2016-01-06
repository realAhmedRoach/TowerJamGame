package dev.thetechnokid.gather.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.thetechnokid.gather.Game;
import dev.thetechnokid.gather.gfx.Tile;
import dev.thetechnokid.gather.input.Keyboard;

public abstract class Entity {
	public int x, y;
	protected Tile tile;
	protected Keyboard handler;

	protected boolean nextSprite = false;
	protected long lastTime;

	public Entity(Tile tile) {
		this.tile = tile;
		this.handler = Game.getCurrentGame().getKeyboard();
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
