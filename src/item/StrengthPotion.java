package item;

import java.util.Random;

import character.Player;

public class StrengthPotion implements Item {
	/**
	 * strength attribute corresponding to the strength to add to a player
	 */
	protected int strength;
	
	/**
	 * StrengthPotion constructor
	 */
	public StrengthPotion() {
		Random r = new Random();
		strength = r.nextInt(5) +1;
	}
	
	
	/**
	 * This method permit to add strength to a player
	 * @param p - Player
	 */
	public void effect(Player p) {
		System.out.println(strength + " points de force sont ajoutes");
		p.addStregth(strength);
	}
	
	public String toString() {
		return "Potion ajoutant " + strength + " points de force";
	}
}
