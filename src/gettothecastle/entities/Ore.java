package gettothecastle.entities;

import java.util.Random;

import gettothecastle.Game;
import gettothecastle.gfx.Tile;
import gettothecastle.input.Keyboard;

public class Ore extends Entity {

	private boolean mined;
	public final int id;
	Random rand = new Random();

	public Ore(Keyboard handler) {
		super(Tile.COAL, handler);
		boolean temp = rand.nextBoolean();
		tile = temp ? Tile.COAL : Tile.IRON;
		if (temp)
			id = 0;
		else
			id = 1;
	}

	@Override
	public void tick() {
		if (mined) {
			return;
		}
		if (handler.isSpace() && Game.getCurrentGame().getScreen()
				.getController().getUser().bounds().intersects(this.bounds())) {
			mined = true;
			tile = Tile.ROCK;
		}
	}

}
