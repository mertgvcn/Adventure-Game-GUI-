package GameProperties;

public class Obstacle {

	private int obsID;
	private String name;
	private int hp, damage, prize;
	private int fullHp;

	public Obstacle(int obsID) {
		this.obsID = obsID;

		switch (obsID) {
		//Orman Canavarlarý
		case 1:
			obsStats("Wild Bee", 15, 4, 18); //damage deðiþkenlik göstersin 3-6 arasýnda mesela
			break;
		case 2:
			obsStats("Grizzly Bear", 30, 6, 25);
			break;
		case 3:
			obsStats("Spider", 40, 7, 30);
			break;
		//Dað Canavarlarý	
		case 4:
			obsStats("Black Bear", 50, 10, 45);
			break;
		case 5:
			obsStats("Golem", 60, 13, 60);
			break;
		case 6:
			obsStats("Giant", 70, 15, 85);
			break;
		//Çöl Canavarlarý	
		case 7:
			obsStats("Scorpion", 75, 18, 110);
			break;
		case 8:
			obsStats("Desert Spider", 85, 22, 145);
			break;
		case 9:
			obsStats("Desert Snake", 100, 30, 250);
			break;	
		default :
			obsStats("Wild Bee", 15, 4, 5);
			break;
		}
	}

	public void obsStats(String name, int hp, int damage, int prize) {
		this.name = name;
		this.hp = hp;
		this.damage = damage;
		this.prize = prize;
		this.fullHp = hp;
	}

	public int getObsID() {
		return obsID;
	}

	public void setObsID(int obsID) {
		this.obsID = obsID;
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

	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	public int getFullHp() {
		return fullHp;
	}

	public void setFullHp(int fullHp) {
		this.fullHp = fullHp;
	}
	

}
