package character;

public class Monster extends GameCharacter {
		
	public Monster(int hp, int strength, int coins) {
		super(hp, strength, coins);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Mosntre : " + hp + " hp / " + strength + " force / " + coins + " coins";
	}
	
}
