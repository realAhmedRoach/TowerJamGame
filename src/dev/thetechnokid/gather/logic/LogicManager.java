package dev.thetechnokid.gather.logic;

public class LogicManager {
	private int coal;
	private int iron;
	private int level;

	public int getCoal() {
		return coal;
	}

	public int getIron() {
		return iron;
	}

	public int getLevel() {
		return level;
	}

	public void increaseCoal() {
		coal++;
	}
	
	public void increaseIron() {
		iron++;
	}
	
	public void increaseLevel() {
		level++;
	}
}
