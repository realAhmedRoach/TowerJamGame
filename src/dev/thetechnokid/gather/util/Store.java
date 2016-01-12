package dev.thetechnokid.gather.util;

import java.awt.event.KeyEvent;

import dev.thetechnokid.gather.Game;

public class Store {
	public static final int[] PRICE_SWORDT1 = { 10, 20 };
	public static final int[] PRICE_SWORDT2 = { 40, 50 };
	public static final int[] PRICE_SWORDT3 = { 50, 55 };

	public static final int[] PRICE_ARMORT1 = { 10, 15 };
	public static final int[] PRICE_ARMORT2 = { 40, 45 };
	public static final int[] PRICE_ARMORT3 = { 50, 100 };
	
	public static synchronized void tick() {
		if (Game.getCurrentGame().getKeyboard().getKeys()[KeyEvent.VK_G]) {
			if (Game.getCurrentGame().getLogicManager().buy(Store.PRICE_SWORDT1[0], Store.PRICE_SWORDT1[1]))
				Game.getCurrentGame().getLogicManager()
						.upgradeSword(1);
		} else if (Game.getCurrentGame().getKeyboard()
				.getKeys()[KeyEvent.VK_H]) {
			if (Game.getCurrentGame().getLogicManager().buy(Store.PRICE_ARMORT2[0], Store.PRICE_ARMORT2[1]))
				Game.getCurrentGame().getLogicManager()
						.upgradeSword(2);
		} else if (Game.getCurrentGame().getKeyboard()
				.getKeys()[KeyEvent.VK_J]) {
			if (Game.getCurrentGame().getLogicManager().buy(Store.PRICE_ARMORT3[0], Store.PRICE_ARMORT3[1]))
				Game.getCurrentGame().getLogicManager()
						.upgradeSword(3);
		}
		
		if (Game.getCurrentGame().getKeyboard().getKeys()[KeyEvent.VK_V]) {
			if (Game.getCurrentGame().getLogicManager().buy(Store.PRICE_ARMORT1[0], Store.PRICE_ARMORT1[1]))
				Game.getCurrentGame().getLogicManager()
						.upgradeArmor(1);
		} else if (Game.getCurrentGame().getKeyboard()
				.getKeys()[KeyEvent.VK_B]) {
			if (Game.getCurrentGame().getLogicManager().buy(Store.PRICE_ARMORT2[0], Store.PRICE_ARMORT2[1]))
				Game.getCurrentGame().getLogicManager()
						.upgradeArmor(2);
		} else if (Game.getCurrentGame().getKeyboard()
				.getKeys()[KeyEvent.VK_N]) {
			if (Game.getCurrentGame().getLogicManager().buy(Store.PRICE_ARMORT3[0], Store.PRICE_ARMORT3[1]))
				Game.getCurrentGame().getLogicManager()
						.upgradeArmor(3);
		}
	}
}
