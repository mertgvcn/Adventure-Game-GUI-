package GameProperties;

public class Inventory {
	private int coin, healthPotion , staminaPotion;
	private boolean dagger, oldSword, longSword, brokenBow, curvedBow, ironBow;
	private boolean lightArmor, solidArmor, heavyArmor;
	
	public Inventory() {
		this.coin = 0;
		this.healthPotion = 0;
		this.staminaPotion = 0;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getHealthPotion() {
		return healthPotion;
	}

	public void setHealthPotion(int healthPotion) {
		this.healthPotion = healthPotion;
	}

	public int getStaminaPotion() {
		return staminaPotion;
	}

	public void setStaminaPotion(int staminaPotion) {
		this.staminaPotion = staminaPotion;
	}

	public boolean isDagger() {
		return dagger;
	}

	public void setDagger(boolean dagger) {
		this.dagger = dagger;
	}

	public boolean isOldSword() {
		return oldSword;
	}

	public void setOldSword(boolean oldSword) {
		this.oldSword = oldSword;
	}

	public boolean isLongSword() {
		return longSword;
	}

	public void setLongSword(boolean longSword) {
		this.longSword = longSword;
	}

	public boolean isBrokenBow() {
		return brokenBow;
	}

	public void setBrokenBow(boolean brokenBow) {
		this.brokenBow = brokenBow;
	}

	public boolean isCurvedBow() {
		return curvedBow;
	}

	public void setCurvedBow(boolean curvedBow) {
		this.curvedBow = curvedBow;
	}

	public boolean isIronBow() {
		return ironBow;
	}

	public void setIronBow(boolean ironBow) {
		this.ironBow = ironBow;
	}

	public boolean isLightArmor() {
		return lightArmor;
	}

	public void setLightArmor(boolean lightArmor) {
		this.lightArmor = lightArmor;
	}

	public boolean isSolidArmor() {
		return solidArmor;
	}

	public void setSolidArmor(boolean solidArmor) {
		this.solidArmor = solidArmor;
	}

	public boolean isHeavyArmor() {
		return heavyArmor;
	}

	public void setHeavyArmor(boolean heavyArmor) {
		this.heavyArmor = heavyArmor;
	}
	
	
	
}
