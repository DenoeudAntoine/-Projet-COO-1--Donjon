package item;

import java.util.Random;

import character.Player;

public class OneHarmedBandit implements Item {

	public OneHarmedBandit() {
		// TODO Auto-generated constructor stub
	}

	public void effect(Player p) {
		// TODO Auto-generated method stub
		if(p.getCoins() > 10) {
			Random r = new Random();
			switch(r.nextInt(3)){
			case 0:
				System.out.println("Le bandit produit une bourse de pièces d'or");
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

	public boolean isPossible() {
		// TODO Auto-generated method stub
		return true;
	}

}
