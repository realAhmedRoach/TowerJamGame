package dev.thetechnokid.gather.entities;

import dev.thetechnokid.gather.Game;
import dev.thetechnokid.gather.gfx.Spritesheet;
import dev.thetechnokid.gather.gfx.Tile;

public class Enemy extends Creature {
	private int speed = 2;
	private int xMove, yMove;
	private boolean diffX, diffY;
	private int userX, userY;

	int frame = 1;
	long lastTime = System.currentTimeMillis();
	private boolean follow;
	private boolean hitted;
	private long lastHit;

	static final Tile walk1 = new Tile(Spritesheet.SHEET.crop(3, 3));
	static final Tile walk2 = new Tile(Spritesheet.SHEET.crop(4, 3));
	static final Tile walk1flip = Tile.flip(walk1);
	static final Tile walk2flip = Tile.flip(walk2);
	static final Tile down1 = new Tile(Spritesheet.SHEET.crop(5, 3));
	static final Tile down2 = new Tile(Spritesheet.SHEET.crop(6, 3));
	static final Tile up1 = new Tile(Spritesheet.SHEET.crop(7, 3));
	static final Tile up2 = new Tile(Spritesheet.SHEET.crop(8, 3));

	public Enemy(boolean follow) {
		super(walk1);
		this.follow = follow;
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

	private void checkDiffs() {
		diffX = Math.abs(userX - x) <= 5;
		diffY = Math.abs(userY - y) <= 5;
		if (diffX)
			xMove = 0;
		if (diffY)
			yMove = 0;
	}

	private void checkPos() {
		if (follow) {
			if (userY > this.y) {
				yMove = speed;
				if ((userX - x) < (userY - y))
					tile = frame == 1 ? down1 : down2;
			}
			if (userY < this.y) {
				yMove = -speed;
				if ((userX - x) > (userY - y))
					tile = frame == 1 ? up1 : up2;
			}
			if (userX > this.x) {
				xMove = speed;
				if ((userY - y) < (userX - x))
					tile = frame == 1 ? walk1 : walk2;
			}
			if (userX < this.x) {
				xMove = -speed;
				if ((userY - y) > (userX - x))
					tile = frame == 1 ? walk1flip : walk2flip;
			}
		} else {
			boolean rand1 = Math.random() < .5;
			boolean rand2 = Math.random() > .6;
			boolean rand3 = Math.random() <= .5;

			if(rand2&&rand3)xMove = rand1 ? speed : -speed;
			if (rand2) {
				yMove = rand3 ? speed : -speed;
			}
		}
	}

	private void move() {
		if (diffX && diffY) {
			tile = down1;
			damage();
		}

		if ((x + xMove) > 0 && (x + xMove) < Game.WIDTH)
			x += xMove;
		if ((y + yMove) > 0 && (y + yMove) < Game.HEIGHT)
			y += yMove;
	}

	private void damage() {
		if (Math.random() < .2)
			return;

		if (System.currentTimeMillis() - lastHit > 400)
			hitted = false;
		if(!hitted){
			Game.getCurrentGame().getScreen().getController().getUser().hit(dmg);
			lastHit = System.currentTimeMillis();
			hitted = true;
		}
	}

}
