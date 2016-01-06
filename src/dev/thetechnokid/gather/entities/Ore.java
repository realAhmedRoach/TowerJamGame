package dev.thetechnokid.gather.entities;

import java.util.Random;

import dev.thetechnokid.gather.Game;
import dev.thetechnokid.gather.gfx.Tile;

public class Ore extends Entity {

	private boolean mined;
	public final int id;
	Random rand = new Random();

	public Ore() {
		super(Tile.COAL);
		boolean temp = rand.nextBoolean();
		tile = temp ? Tile.COAL : Tile.IRON;
		if (temp)
			id = 0;
		else
			id = 1;
	}

	@Override
	public void tick() {
		if (isMined()) {
			return;
		}
		if (handler.isSpace() && Game.getCurrentGame().getScreen()
				.getController().getUser().bounds().intersects(this.bounds())) {
			mined = true;
			if(id == 0) Game.getCurrentGame().getLogicManager().increaseCoal();
			else if (id == 1) Game.getCurrentGame().getLogicManager().increaseIron();
			tile = Tile.ROCK;
		}
	}

	public boolean isMined() {
		return mined;
	}

}
