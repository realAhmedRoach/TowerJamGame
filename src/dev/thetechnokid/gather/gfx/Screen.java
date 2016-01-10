package dev.thetechnokid.gather.gfx;

import java.awt.Graphics;

import dev.thetechnokid.gather.Game;
import dev.thetechnokid.gather.entities.*;
import dev.thetechnokid.gather.stages.Menu;
import dev.thetechnokid.gather.stages.Stage;

public class Screen {
	public final int width, height;

	public static final int MAP_SIZE = 8;

	private Map map;
	private EntityController ec;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		map = new Map(this);
		ec = new EntityController();

		Stage.setCurrentStage(new Menu());
	}

	public Map getMap() {
		return map;
	}

	public EntityController getController() {
		return ec;
	}

	public void tick() {
		map.tick();
		ec.tick();
		Stage.getCurrentStage().tick();
	}

	public void render(Graphics g) {
		map.render(g);
		ec.render(g);
		Stage.getCurrentStage().render(g, this);
		Text.render(Game.getCurrentGame().getLogicManager().getStatusText(),
				g, 16, Game.HEIGHT - 24);
	}
}
