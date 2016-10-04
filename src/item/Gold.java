package item;

import java.util.Random;

import character.Player;

public class Gold implements Item {
	
	protected int coins;
	
	public Gold() {
		// TODO Auto-generated constructor stub
		Random r = new Random();
		coins = r.nextInt(19) + 1;
	}

	public void effect(Player p) {
		// TODO Auto-generated method stub
		System.out.println(coins + " coins vont être ajouté à la bourse !");
		p.addGolds(coins);
	}

	public boolean isPossible() {
		// TODO Auto-generated method stub
		return true;
	}

}
