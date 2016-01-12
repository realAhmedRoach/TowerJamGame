package dev.thetechnokid.gather.entities;

import dev.thetechnokid.gather.Game;
import dev.thetechnokid.gather.gfx.Tile;

public class Enemy extends Entity {
	private int spd = 1;
	private int xMove, yMove;
	private boolean diffX, diffY;

	public Enemy() {
		super(Tile.PLAYER_UP1);
	}

	@Override
	public void tick() {
		int userX = Game.getCurrentGame().getScreen().getController()
				.getUser().x;
		int userY = Game.getCurrentGame().getScreen().getController()
				.getUser().x;

		if (userX > this.x) {
			xMove = spd;
		}
		if (userX < this.x) {
			xMove = -spd;
		}
		if (userY > this.y) {
			yMove = spd;
		}
		if (userY < this.y) {
			yMove = -spd;
		}
		if (diffX)
			xMove = 0;
		if (diffY)
			yMove = 0;
		diffX = Math.abs(userX - x) <= 5;
		diffY = Math.abs(userY - y) <= 5;
		move();
	}

	private void move() {
		x += xMove;
		y += yMove;
	}

}
