package item;

import java.util.Random;

import character.Player;

public class HealthPotion implements Item {
	
	protected int heal;
	
	public HealthPotion() {
		// TODO Auto-generated constructor stub
		Random r = new Random();
		heal = r.nextInt(10) + 5;
	}

	public void effect(Player p) {
		// TODO Auto-generated method stub
		System.out.println(heal + " hp vont être ajouté !");
		p.heal(heal);
	}

	public boolean isPossible() {
		// TODO Auto-generated method stub
		return true;
	}

}
