package dev.thetechnokid.gather.entities;

import dev.thetechnokid.gather.Game;
import dev.thetechnokid.gather.gfx.Spritesheet;
import dev.thetechnokid.gather.gfx.Tile;

public class Enemy extends Entity {
	private int spd = 2;
	private int xMove, yMove;
	private boolean diffX, diffY;
	private int userX, userY;

	int frame = 1;
	long lastTime = System.currentTimeMillis();

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
		checkAnim();
		setUserPos();
		checkPos();
		checkDiffs();
		move();
	}

	private void setUserPos() {
		userX = Game.getCurrentGame().getScreen().getController().getUser().x;
		userY = Game.getCurrentGame().getScreen().getController().getUser().y;
	}

	private void checkAnim() {
		if (System.currentTimeMillis() - lastTime >= 200) {
			if (frame == 1)
				frame = 2;
			else
				frame = 1;
			lastTime = System.currentTimeMillis();
		}
	}

	private void checkDiffs() {
		diffX = Math.abs(userX - x) <= 1;
		diffY = Math.abs(userY - y) <= 1;
		if (diffX)
			xMove = 0;
		if (diffY)
			yMove = 0;
	}

	private void checkPos() {
		if (userY > this.y) {
			yMove = spd;
			if ((userX - x) < (userY - y))
				tile = frame == 1 ? down1 : down2;
		}
		if (userY < this.y) {
			yMove = -spd;
			if ((userX - x) > (userY - y))
				tile = frame == 1 ? up1 : up2;
		}
		if (userX > this.x) {
			xMove = spd;
			if ((userY - y) < (userX - x))
				tile = frame == 1 ? walk1 : walk2;
		}
		if (userX < this.x) {
			xMove = -spd;
			if ((userY - y) > (userX - x))
				tile = frame == 1 ? walk1flip : walk2flip;
		}
	}

	private void move() {
		if (diffX && diffY)
			tile = down1;
		x += xMove;
		y += yMove;
	}

}
