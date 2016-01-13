package dev.thetechnokid.gather.entities;

import dev.thetechnokid.gather.Game;
import dev.thetechnokid.gather.gfx.Spritesheet;
import dev.thetechnokid.gather.gfx.Tile;

public class Enemy extends Entity {
	private int spd = 1;
	private int xMove, yMove;
	private boolean diffX, diffY;

	static Tile walk1 = new Tile(Spritesheet.SHEET.crop(3, 3));
	static Tile walk2 = new Tile(Spritesheet.SHEET.crop(4, 3));
	static Tile walk1flip = Tile.flip(walk1);
	static Tile walk2flip = Tile.flip(walk2);
	static Tile down1 = new Tile(Spritesheet.SHEET.crop(5, 3));
	static Tile down2 = new Tile(Spritesheet.SHEET.crop(6, 3));
	static Tile up1 = new Tile(Spritesheet.SHEET.crop(7, 3));
	static Tile up2 = new Tile(Spritesheet.SHEET.crop(8, 3));
	public Enemy() {
		super(walk1);
	}

	@Override
	public void tick() {
		int userX = Game.getCurrentGame().getScreen().getController()
				.getUser().x;
		int userY = Game.getCurrentGame().getScreen().getController()
				.getUser().y;

		if (userX > this.x) {
			xMove = spd;
			tile = walk1;
		}
		if (userX < this.x) {
			xMove = -spd;
			tile = walk1flip;
		}
		if (userY > this.y) {
			yMove = spd;
			tile = down1;
		}
		if (userY < this.y) {
			yMove = -spd;
			tile = up1;
		}
		diffX = Math.abs(userX - x) <= 5;
		diffY = Math.abs(userY - y) <= 5;
		if (diffX)
			xMove = 0;
		if (diffY)
			yMove = 0;
		move();
	}

	private void move() {
		x += xMove;
		y += yMove;
	}

}
