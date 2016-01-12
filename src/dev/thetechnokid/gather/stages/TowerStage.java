package dev.thetechnokid.gather.stages;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dev.thetechnokid.gather.Game;
import dev.thetechnokid.gather.entities.Tower;
import dev.thetechnokid.gather.gfx.*;
import dev.thetechnokid.gather.util.Store;

public class TowerStage extends Stage {

	Tower t = new Tower();
	// 0 = menu, 1 = shop, 2 = tier checker
	private int phase = 0;

	public TowerStage() {
		t.x = 11 * Tile.DRAW_SIZE;
		t.y = Tile.DRAW_SIZE;
		Game.getCurrentGame().getScreen().getController().clearEntities();
	}

	@Override
	public void render(Graphics g, Screen screen) {
		t.render(g);
		renderPhase(g);
	}

	private void renderPhase(Graphics g) {
		if (phase == 1) {
			renderSwordShop(g);
			renderArmorShop(g);
		} else if (phase == 2) {
			Text.render(
					"Armor Tier " + Game.getCurrentGame().getLogicManager()
							.getArmorTier(),
					g, Tile.DRAW_SIZE, 9 * Tile.DRAW_SIZE);
			Text.render(
					"Sword Tier " + Game.getCurrentGame().getLogicManager()
							.getSwordTier(),
					g, Tile.DRAW_SIZE, 11 * Tile.DRAW_SIZE);
		} else {
			Text.render("1 for shop  2 for tiers", g, Tile.DRAW_SIZE,
					9 * Tile.DRAW_SIZE);
		}
	}

	private void renderSwordShop(Graphics g) {
		Text.render(
				"Swords  g Tier1 " + Store.PRICE_SWORDT1[0] + "C "
						+ Store.PRICE_SWORDT1[1] + "I",
				g, Tile.DRAW_SIZE, 8 * Tile.DRAW_SIZE);
		Text.render(
				"h Tier2 " + Store.PRICE_SWORDT2[0] + "C "
						+ Store.PRICE_SWORDT2[1] + "I",
				g, 9 * Tile.DRAW_SIZE + (Tile.DRAW_SIZE / 2),
				9 * Tile.DRAW_SIZE + (Tile.DRAW_SIZE / 2));
		Text.render(
				"j Tier3 " + Store.PRICE_SWORDT3[0] + "C "
						+ Store.PRICE_SWORDT3[1] + "I",
				g, 9 * Tile.DRAW_SIZE + (Tile.DRAW_SIZE / 2),
				10 * Tile.DRAW_SIZE + (Tile.DRAW_SIZE));
	}

	private void renderArmorShop(Graphics g) {
		Text.render(
				"Armors  v Tier1 " + Store.PRICE_ARMORT1[0] + "C "
						+ Store.PRICE_ARMORT1[1] + "I",
				g, Tile.DRAW_SIZE, 13 * Tile.DRAW_SIZE);
		Text.render(
				"b Tier2 " + Store.PRICE_ARMORT2[0] + "C "
						+ Store.PRICE_ARMORT2[1] + "I",
				g, 9 * Tile.DRAW_SIZE + (Tile.DRAW_SIZE / 2),
				14 * Tile.DRAW_SIZE + (Tile.DRAW_SIZE / 2));
		Text.render(
				"n Tier3 " + Store.PRICE_ARMORT3[0] + "C "
						+ Store.PRICE_ARMORT3[1] + "I",
				g, 9 * Tile.DRAW_SIZE + (Tile.DRAW_SIZE / 2),
				16 * Tile.DRAW_SIZE);
	}

	@Override
	public void tick() {
		if (Game.getCurrentGame().getKeyboard().getKeys()[KeyEvent.VK_1]) {
			phase = 1;
		} else if (Game.getCurrentGame().getKeyboard()
				.getKeys()[KeyEvent.VK_2]) {
			phase = 2;
		}

		Store.tick();
	}

}
