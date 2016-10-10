package item;

import java.util.Random;

import character.Player;

public class HealthPotion implements Item {
	/**
	 * heal attribute corresponding to the number of points of life to caring
	 */
	protected int heal;
	
	/**
	 * HealthPotion constructor
	 */
	public HealthPotion() {
		Random r = new Random();
		heal = r.nextInt(10) + 5;
	}
	
	
	/**
	 * This method permit to heal a player
	 * @param p - Player
	 */
	public void effect(Player p) {
		System.out.println(heal + " hp vont etre ajoute !");
		p.heal(heal);
	}
	
	
	public String toString() {
		return "Potion de " + heal + " points de vie";
	}
}
