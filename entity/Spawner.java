package entity;


import level.Level;

public class Spawner extends Entity{
	
	@SuppressWarnings("unused")
	private Type type;
	public enum Type{
		PARTICLE, MOB;
	}
	
	
	
	public Spawner(int x, int y, Type type, int amount, Level level) {
		init(level);
		this.x = x;
		this.y = y;
		this.type = type;
	}

}
