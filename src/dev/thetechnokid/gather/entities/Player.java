package dev.thetechnokid.gather.entities;

import dev.thetechnokid.gather.Game;
import dev.thetechnokid.gather.gfx.Tile;

public class Player extends Creature {

	private final int speed = 3;
	private final int dmg = 10;
	private final int def = 10;

	int frame = 1;
	long lastTime = System.currentTimeMillis();

	private boolean hitted;
	private long lastHit;

	public Player() {
		super(Tile.PLAYER_WALK1);
	}

	@Override
	public void tick() {
		checkAnim();
		checkInput();
		checkHits();
	}

	private void checkHits() {
		for (Entity e : Game.getCurrentGame().getScreen().getController()
				.getEntities()) {
			if (e instanceof Enemy) {
				Enemy enemy = (Enemy) e;
				if (bounds().intersects(enemy.bounds()) && handler.isSpace()
						&& !hitted) {
					enemy.hit(dmg * (Game.getCurrentGame().getLogicManager()
							.getSwordTier() + 1));
					System.out.println(Game.getCurrentGame().getLogicManager()
							.getSwordTier() + 1);
					hitted = true;
					lastHit = System.currentTimeMillis();
				}
			}
		}
		if (System.currentTimeMillis() - lastHit > 400)
			hitted = false;
	}

	private void checkInput() {
		if (handler.isUp()) {
			y -= speed;
			if (y < 0)
				y = 0;
			this.tile = frame == 1 ? Tile.PLAYER_UP1 : Tile.PLAYER_UP2;
		}
		if (handler.isDown()) {
			y += speed;
			if (y > Game.HEIGHT - Tile.DRAW_SIZE)
				y = Game.HEIGHT - Tile.DRAW_SIZE;
			this.tile = frame == 1 ? Tile.PLAYER_DOWN1 : Tile.PLAYER_DOWN2;
		}
		if (handler.isRight()) {
			x += speed;
			if (x >= Game.WIDTH - Tile.DRAW_SIZE)
				x = Game.WIDTH - Tile.DRAW_SIZE;
			this.tile = frame == 1 ? Tile.PLAYER_WALK1 : Tile.PLAYER_WALK2;
		}
		if (handler.isLeft()) {
			x -= speed;
			if (x < 0)
				x = 0;
			this.tile = frame == 1 ? Tile.PLAYER_WALK1FLIP
					: Tile.PLAYER_WALK2FLIP;
		}
	}

	public void hit(int damage) {
		super.hit(damage - (def
				* Game.getCurrentGame().getLogicManager().getArmorTier()));
	}
}
