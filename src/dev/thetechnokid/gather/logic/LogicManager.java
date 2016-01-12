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

	public void buy(int coal, int iron) {
		if (coal < this.coal && iron < this.iron) {
			this.coal -= coal;
			this.iron -= iron;
		}
	}

	public boolean upgradeArmor(int tier) {
		if (tier <= 3 && tier > 0 && armorTier < tier) {
			armorTier = tier;
			return true;
		}
		return false;
	}

	public boolean upgradeSword(int tier) {
		
		if (tier <= 3 && tier > 0 && swordTier < tier) {
			System.out.println("hey");
			swordTier = tier;
			return true;
		}
		return false;
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
