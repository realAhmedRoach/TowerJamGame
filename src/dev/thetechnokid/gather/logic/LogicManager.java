package dev.thetechnokid.gather.logic;

public class LogicManager {
	private int coal;
	private int iron;
	private int level;
	private String statusText;
	private boolean statusCustom;

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

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		statusCustom = true;
		this.statusText = statusText;
	}
	
	public void tick() {
		if(!statusCustom) 
			this.statusText = "Coal " + getCoal() + " Iron " + getIron();
	}
}
