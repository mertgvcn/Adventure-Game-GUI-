package GameProperties;

public class Character {
	private String name;
	private int damage, hp, stamina, armor, extraDamage, extraArmor, totalDamage, totalArmor;
	private int fullHp, fullStamina;
	private Inventory inv;
	private int chaId;
	private int forest_lvl = 1, mountain_lvl = 1, desert_lvl = 1;

	public Character() {
		this.inv = new Inventory();
	}

	public Character(String name) {
		this.name = name;
	}

	public Character(int damage, int hp, int stamina, int armor) {
		this.damage = damage;
		this.hp = hp;
		this.stamina = stamina;
		this.armor = armor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	public int getFullHp() {
		return fullHp;
	}

	public void setFullHp(int fullHp) {
		this.fullHp = fullHp;
	}

	public int getFullStamina() {
		return fullStamina;
	}

	public void setFullStamina(int fullStamina) {
		this.fullStamina = fullStamina;
	}

	public int getExtraDamage() {
		return extraDamage;
	}

	public void setExtraDamage(int extraDamage) {
		this.extraDamage = extraDamage;
	}

	public int getExtraArmor() {
		return extraArmor;
	}

	public void setExtraArmor(int extraArmor) {
		this.extraArmor = extraArmor;
	}

	public int getChaId() {
		return chaId;
	}

	public void setChaId(int chaId) {
		this.chaId = chaId;
	}

	public int getTotalDamage() {
		return damage + extraDamage;
	}

	public void setTotalDamage(int totalDamage) {
		this.totalDamage = totalDamage;
	}

	public int getTotalArmor() {
		return armor + extraArmor;
	}

	public void setTotalArmor(int totalArmor) {
		this.totalArmor = totalArmor;
	}

	public int getForest_lvl() {
		return forest_lvl;
	}

	public void setForest_lvl(int forest_lvl) {
		this.forest_lvl = forest_lvl;
	}

	public int getMountain_lvl() {
		return mountain_lvl;
	}

	public void setMountain_lvl(int mountain_lvl) {
		this.mountain_lvl = mountain_lvl;
	}

	public int getDesert_lvl() {
		return desert_lvl;
	}

	public void setDesert_lvl(int desert_lvl) {
		this.desert_lvl = desert_lvl;
	}

}