package dev.thetechnokid.gather.entities;

import java.awt.Graphics;

public class Tower extends Entity {

	private Model model;
	
	public Tower() {
		super(null);
		model = new Model("tower");
	}
	
	@Override
	public void render(Graphics g) {
		model.render(g, x, y);
	}

	@Override
	public void tick() {
	}

}
