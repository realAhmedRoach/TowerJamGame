package dev.thetechnokid.gather.stages;

import java.awt.Graphics;

import dev.thetechnokid.gather.Game;
import dev.thetechnokid.gather.gfx.*;

public class Menu extends Stage {

	@Override
	public void render(Graphics g, Screen screen) {
		String msg = Game.NAME;
		Text.render(msg, g, 9*Tile.DRAW_SIZE,
				4*Tile.DRAW_SIZE);
		Text.render("Gather for the tower", g, 3*Tile.DRAW_SIZE, 10*Tile.DRAW_SIZE);
		Text.render("space to start", g, 5*Tile.DRAW_SIZE, 13*Tile.DRAW_SIZE);
	}

	@Override
	public void tick() {
		if (Game.getCurrentGame().getKeyboard().isSpace()) {
			Stage.setCurrentStage(new Gameplay());
		}
	}

}
