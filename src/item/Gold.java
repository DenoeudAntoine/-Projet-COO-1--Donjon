package item;

import java.util.Random;

import character.Player;

public class Gold implements Item {
	/**
	 * coins attribute corresponding to item coin
	 */
	protected int coins;
	
	/**
	 * Gold constructor
	 */
	public Gold() {
		Random r = new Random();
		coins = r.nextInt(19) + 1;
	}
	
	
	/**
	 * This method permit to add coins to a player
	 * @param p - Player
	 */
	public void effect(Player p) {
		System.out.println(coins + " pieces vont etre ajoute a la bourse !");
		p.addGolds(coins);
	}

	
	public String toString() {
		return coins + " pieces d'or";
	}

}
