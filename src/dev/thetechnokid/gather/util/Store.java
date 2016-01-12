package dev.thetechnokid.gather.util;

import java.awt.event.KeyEvent;

import dev.thetechnokid.gather.Game;

public class Store {
	public static final int[] PRICE_SWORDT1 = { 1, 3 };
	public static final int[] PRICE_SWORDT2 = { 2, 6 };
	public static final int[] PRICE_SWORDT3 = { 3, 8 };

	public static final int[] PRICE_ARMORT1 = { 2, 4 };
	public static final int[] PRICE_ARMORT2 = { 3, 8 };
	public static final int[] PRICE_ARMORT3 = { 5, 10 };
	
	public static synchronized void tick() {
		if (Game.getCurrentGame().getKeyboard().getKeys()[KeyEvent.VK_G]) {
			if (Game.getCurrentGame().getLogicManager().upgradeSword(1))
				Game.getCurrentGame().getLogicManager()
						.buy(Store.PRICE_SWORDT1[0], Store.PRICE_SWORDT1[1]);
		} else if (Game.getCurrentGame().getKeyboard()
				.getKeys()[KeyEvent.VK_H]) {
			if (Game.getCurrentGame().getLogicManager().upgradeSword(2))
				Game.getCurrentGame().getLogicManager()
						.buy(Store.PRICE_ARMORT2[0], Store.PRICE_ARMORT2[1]);
		} else if (Game.getCurrentGame().getKeyboard()
				.getKeys()[KeyEvent.VK_J]) {
			if (Game.getCurrentGame().getLogicManager().upgradeSword(3))
				Game.getCurrentGame().getLogicManager()
						.buy(Store.PRICE_ARMORT3[0], Store.PRICE_ARMORT3[1]);
		}
		
		if (Game.getCurrentGame().getKeyboard().getKeys()[KeyEvent.VK_V]) {
			if (Game.getCurrentGame().getLogicManager().upgradeArmor(1))
				Game.getCurrentGame().getLogicManager()
						.buy(Store.PRICE_ARMORT1[0], Store.PRICE_ARMORT1[1]);
		} else if (Game.getCurrentGame().getKeyboard()
				.getKeys()[KeyEvent.VK_B]) {
			if (Game.getCurrentGame().getLogicManager().upgradeArmor(2))
				Game.getCurrentGame().getLogicManager()
						.buy(Store.PRICE_ARMORT2[0], Store.PRICE_ARMORT2[1]);
		} else if (Game.getCurrentGame().getKeyboard()
				.getKeys()[KeyEvent.VK_N]) {
			if (Game.getCurrentGame().getLogicManager().upgradeArmor(3))
				Game.getCurrentGame().getLogicManager()
						.buy(Store.PRICE_ARMORT3[0], Store.PRICE_ARMORT3[1]);
		}
	}
}
