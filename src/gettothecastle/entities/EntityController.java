package gettothecastle.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import gettothecastle.Game;

public class EntityController {
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	private Player currUser;
	
	public EntityController() {
		currUser = new Player(Game.getCurrentGame().getKeyboard());
		entities.add(currUser);
	}

	public Player getUser() {
		return currUser;
	}

	public void setUser(Player currUser) {
		this.currUser = currUser;
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public void removeEntity(Entity e) {
		entities.remove(e);
	}
	
	public Entity getEntity(int index) {
		return entities.get(index);
	}
	
	public void tick() {
		for (Entity entity : entities) {
			entity.tick();
		}
	}
	
	public void render(Graphics g) {
		for (int i = entities.size()-1; i >= 0; i--) {
			entities.get(i).render(g);
		}
	}
}
