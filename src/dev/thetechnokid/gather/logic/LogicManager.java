package dev.thetechnokid.gather.logic;

public class LogicManager {
	private int coal;
	private int iron;

	private int armorTier;
	private int swordTier;

	private String statusText;
	public boolean statusCustom;

	public int getCoal() {
		return coal;
	}

	public int getIron() {
		return iron;
	}

	public int getArmorTier() {
		return armorTier;
	}

	public int getSwordTier() {
		return swordTier;
	}

	public void increaseCoal() {
		coal++;
	}

	public void increaseIron() {
		iron++;
	}

	public boolean buy(int coal, int iron) {
		if (coal < this.coal && iron < this.iron) {
			this.coal -= coal;
			this.iron -= iron;
			return true;
		}
		return false;
	}

	public void upgradeArmor(int tier) {
		if (tier <= 3 && tier > 0 && armorTier < tier) {
			armorTier = tier;
		}
	}

	public void upgradeSword(int tier) {
		if (tier <= 3 && tier > 0 && swordTier < tier) {
			swordTier = tier;
		}
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		statusCustom = true;
		this.statusText = statusText;
	}

	public void tick() {
		if (!statusCustom)
			this.statusText = "Coal " + getCoal() + " Iron " + getIron();
	}
}
