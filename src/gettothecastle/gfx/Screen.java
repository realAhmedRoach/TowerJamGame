package gettothecastle.gfx;

import java.awt.Graphics;

import gettothecastle.Game;
import gettothecastle.entities.Player;
import gettothecastle.stages.Menu;
import gettothecastle.stages.Stage;

public class Screen {
	public final int width, height;

	public static final int MAP_SIZE = 8;

	private Map map;
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		map = new Map(this);
		

		Stage.setCurrentStage(new Menu());
		map.addEntity(new Player(Game.getCurrentGame().getKeyboard()));
	}

	public void tick() {
		map.tick();
	}
	
	public void render(Graphics g) {
		map.render(g);
	}
}
