package character;

public abstract class GameCharacter {
	/**
	 * hp attribute corresponding to character's life
	 */
	protected int hp;
	
	/**
	 * strenght attribute corresponding to character's strength
	 */
	protected int strength;
	
	/**
	 * coins attribute corresponding to the number of coins of character
	 */
	protected int coins;
	
	
	/**
	 * GameCharacter constructor
	 * @param hp - Character's life
	 * @param strength - Character's strength
	 * @param coins - Number of coins of character
	 */
	public GameCharacter(int hp, int strength, int coins) {
		this.hp = hp;
		this.strength = strength;
		this.coins = coins;
	}
	
	
	/**
	 * Strength getter
	 * @return character's strength
	 */
	public int getStrength() {
		return this.strength;
	}
	
	
	/**
	 * coins getter
	 * @return character's coins
	 */
	public int getCoins() {
		return coins;
	}
	
	
	/**
	 * hp getter
	 * @return character's hp
	 */
	public int getHP() {
		return hp;
	}
	
	
	/**
	 * Withdrawal of life points after attack
	 * @param c - Character who launched the attack
	 */
	public void isAttacked(GameCharacter c) {
		this.hp -= c.getStrength();
	}
	
	public abstract String toString();
}
