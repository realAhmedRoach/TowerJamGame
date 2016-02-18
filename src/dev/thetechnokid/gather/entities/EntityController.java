package dev.thetechnokid.gather.entities;

import java.awt.Graphics;
import java.util.concurrent.CopyOnWriteArrayList;

public class EntityController {
	private CopyOnWriteArrayList<Entity> entities = new CopyOnWriteArrayList<Entity>();
	private Player currUser;
	
	public EntityController() {
		currUser = new Player();
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
	
	public synchronized void tick() {
		for (Entity entity : entities) {
			if (entity.destroyed) entities.remove(entity);
		}
//		if (!entities.contains(currUser)) System.out.println("DEAD!");
		for (Entity entity : entities) {
			entity.tick();
		}
	}
	
	public synchronized void render(Graphics g) {
		for (int i = entities.size()-1; i >= 0; i--) {
			entities.get(i).render(g);
		}
	}

	public CopyOnWriteArrayList<Entity> getEntities() {
		return entities;
	}

	public void clearEntities() {
		for (int i = entities.size()-1; i >= 0; i--) {
			if(entities.get(i)!=currUser)
				entities.remove(i);
		}
		if(!entities.contains(currUser)) {
			currUser.hp = 100;
			currUser.destroyed = false;
			entities.add(currUser);
		}
	}
}
