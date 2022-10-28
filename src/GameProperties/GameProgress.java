package GameProperties;

public class GameProgress {

	private boolean itm_spiderEye , itm_mushroom , itm_snakePosion ;
	
	public GameProgress() {
		itm_snakePosion = false;
		itm_mushroom = false;
		itm_spiderEye = false;
	}

	public boolean isItm_spiderEye() {
		return itm_spiderEye;
	}

	public void setItm_spiderEye(boolean itm_spiderEye) {
		this.itm_spiderEye = itm_spiderEye;
	}

	public boolean isItm_mushroom() {
		return itm_mushroom;
	}

	public void setItm_mushroom(boolean itm_mushroom) {
		this.itm_mushroom = itm_mushroom;
	}

	public boolean isItm_snakePosion() {
		return itm_snakePosion;
	}

	public void setItm_snakePosion(boolean itm_snakePosion) {
		this.itm_snakePosion = itm_snakePosion;
	}
	
	
}
