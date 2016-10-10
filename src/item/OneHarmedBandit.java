package item;

import java.util.Random;

import character.Player;

public class OneHarmedBandit implements Item {
	/**
	 * OneHarmedBandit constructor
	 */
	public OneHarmedBandit() {
		
	}
	
	
	/**
	 * This method permit to generate a random item and use it
	 * @param p - Player
	 */
	public void effect(Player p) {
		if(p.getCoins() > 10) {
			Random r = new Random();
			switch(r.nextInt(3)){
			case 0:
				System.out.println("Le bandit produit une bourse de pieces d'or");
				new Gold().effect(p);
				break;
			case 1:
				System.out.println("Le bandit produit une potion de soin");
				new HealthPotion().effect(p);
				break;
			case 2:
				System.out.println("Le bandit produit une potion de force");
				new StrengthPotion().effect(p);
				break;
			}
		} else {
			System.out.println("Tu n'as pas assez d'or pour payer le bandit.");
		}		
	}
	
	
	public String toString() {
		return "Bandit manchot";
	}
}
