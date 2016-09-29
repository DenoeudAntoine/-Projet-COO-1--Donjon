package character;

public abstract class GameCharacter {
	protected int hp;
	protected int strength;
	protected int coins;
	
	public GameCharacter(int hp, int strength, int coins) {
		this.hp = hp;
		this.strength = strength;
		this.coins = coins;
	}

	public int getStrength() {
		// TODO Auto-generated method stub
		return this.strength;
	}
}
