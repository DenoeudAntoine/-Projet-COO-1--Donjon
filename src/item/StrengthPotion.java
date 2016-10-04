package item;

import java.util.Random;

import character.Player;

public class StrengthPotion implements Item {

	protected int strength;
	
	public StrengthPotion() {
		// TODO Auto-generated constructor stub
		Random r = new Random();
		strength = r.nextInt(5) +1;
	}

	public void effect(Player p) {
		// TODO Auto-generated method stub
		System.out.println(strength + " points de force sont ajoutés");
	}

	public boolean isPossible() {
		// TODO Auto-generated method stub
		return true;
	}

}
