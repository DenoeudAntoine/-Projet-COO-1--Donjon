package character;

public class Monster extends GameCharacter {
	/**
	 * Monster constructor
	 * @param hp - Character's life
	 * @param strength - Character's strength
	 * @param coins - Number of coins of character
	 */
	public Monster(int hp, int strength, int coins) {
		super(hp, strength, coins);
	}

	@Override
	public String toString() {
		return "Monstre : " + hp + " hp / " + strength + " force / " + coins + " coins";
	}
	
}
