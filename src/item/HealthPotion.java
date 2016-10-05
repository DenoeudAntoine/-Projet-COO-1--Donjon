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
		System.out.println(heal + " hp vont �tre ajout� !");
		p.heal(heal);
	}
	
	public String toString() {
		return "Potion de " + heal + " points de vie";
	}

}
