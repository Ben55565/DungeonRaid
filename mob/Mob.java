package mob;

import entity.Entity;
import myGameGraphics.Sprite;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	public void move() {
		
	}
	
	public void updae() {
		
	}
	
	private boolean collision() {
		return false;
	}
}
