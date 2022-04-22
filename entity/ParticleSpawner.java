package entity;


import level.Level;

public class ParticleSpawner extends Spawner {

	@SuppressWarnings("unused")
	private int timeAlive;

	public ParticleSpawner(int x, int y, int timeAlive, int amount, Level level) {
		super(x, y, Type.PARTICLE, amount, level);
		this.timeAlive = timeAlive;
		for (int i = 0; i < amount; i++) {
			level.add(new Particle(x, y, timeAlive));

		}
	}

}
