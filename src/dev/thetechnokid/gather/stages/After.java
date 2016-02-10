package dev.thetechnokid.gather.stages;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dev.thetechnokid.gather.Game;
import dev.thetechnokid.gather.gfx.*;

public class After extends Stage {

	private boolean lost;

	private boolean doneStuff;

	public After(boolean lost) {
		this.lost = lost;
	}

	@Override
	public void render(Graphics g, Screen screen) {
		Text.render("You have " + (lost ? "lost" : "won"), g, 5 * Tile.DRAW_SIZE, 3 * Tile.DRAW_SIZE);
		if (lost) {
			if (!doneStuff) {
				int[] lose = lose();
				Text.render("You lost " + lose[0] + "C and " + lose[1] + "I", g, 5 * Tile.DRAW_SIZE,
						5 * Tile.DRAW_SIZE);
			}
		} else {
			if (!doneStuff) {
				int[] win = win();
				Text.render("You won " + win[0] + "C and " + win[1] + "I", g, 5 * Tile.DRAW_SIZE, 5 * Tile.DRAW_SIZE);
			}
		}

		Text.render("1 to re-play", g, 5 * Tile.DRAW_SIZE, 7 * Tile.DRAW_SIZE);
	}

	private int[] lose() {
		int loseAmtC = (int) Math.random() * (Game.getCurrentGame().getLogicManager().getCoal() / 2);
		int loseAmtI = (int) Math.random() * (Game.getCurrentGame().getLogicManager().getIron() / 2);

		Game.getCurrentGame().getLogicManager().buy(loseAmtC, loseAmtI);
		return new int[] { loseAmtC, loseAmtI };
	}

	private int[] win() {
		int winAmtC = (int) Math.random() * (Game.getCurrentGame().getLogicManager().getCoal() / 2);
		int winAmtI = (int) Math.random() * (Game.getCurrentGame().getLogicManager().getIron() / 2);

		for (int i = 0; i < winAmtC; i++)
			Game.getCurrentGame().getLogicManager().increaseCoal();
		for (int i = 0; i < winAmtI; i++)
			Game.getCurrentGame().getLogicManager().increaseIron();
		return new int[] { winAmtC, winAmtI };
	}

	@Override
	public void tick() {
		if (Game.getCurrentGame().getKeyboard().getKeys()[KeyEvent.VK_1])
			Stage.setCurrentStage(new Gameplay());
	}

}
