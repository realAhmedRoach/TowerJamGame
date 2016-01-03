package gettothecastle.entities;

import gettothecastle.Game;
import gettothecastle.gfx.Tile;
import gettothecastle.input.Keyboard;

public class Player extends Entity {

	private final int speed = 2;

	public Player(Keyboard handler) {
		super(Tile.PLAYER_WALK1, handler);
	}

	@Override
	public void tick() {
		super.tick();
		if (handler.isUp()) {
			y -= speed;
			if (y < 0)
				y = 0;
			if (y > Game.HEIGHT - Tile.DRAW_SIZE)
				y = Game.HEIGHT - Tile.DRAW_SIZE;
			this.tile = nextSprite ? Tile.PLAYER_UP1 : Tile.PLAYER_UP2;
		}
		if (handler.isDown()) {
			y += speed;
			this.tile = Tile.PLAYER_DOWN1;
		}
		if (handler.isRight()) {
			x += speed;
			this.tile = Tile.PLAYER_WALK1;
		}
		if (handler.isLeft()) {
			x -= speed;
			this.tile = Tile.PLAYER_WALK1FLIP;
		}
	}

}
