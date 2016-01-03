package dev.thetechnokid.gather.entities;

import java.util.Random;

import dev.thetechnokid.gather.Game;
import dev.thetechnokid.gather.gfx.Tile;
import dev.thetechnokid.gather.input.Keyboard;

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
