package character;

import item.Item;

import java.util.ArrayList;
import java.util.List;

import scanner.ScannerInt;

import action.Action;

public class Player extends GameCharacter {
	protected List<Item> lstItems = new ArrayList<Item>();
	
	protected List<Action> lActions = new ArrayList<Action>();
	
	protected List<String> possibleActions = new ArrayList<String>();
	
	public Player(int hp, int strength, int coins) {
		super(hp, strength, coins);
		// TODO Auto-generated constructor stub
	}
	
	public List<Action> getActions() {
		return lActions;
	}
	
	public void removeAll() {
		lActions = new ArrayList<Action>();
	}
	
	public void heal(int hp) {
		
		this.hp += hp;
	}
	
	public void addGolds(int coins){
		this.coins = coins;
	}
	
	public void addStregth(int strength) {
		this.strength = strength;
	}
	
	public int getCoins() {
		return coins;
	}
	
	public void act() {
		Action action = this.chose(lActions);
        action.execute(this);
	}
	
	/**
	 * @param a
	 */
	public void addAction(Action a) {
		lActions.add(a);
	}
	

	public <T> T chose(List <T> liste) {
		int i = 0;
		do {
			System.out.println("Veuillez choisir une action\n0 : return null");
		
			for(T o : liste)
				System.out.println( ++i + " : " + o);
			
			i = ScannerInt.readInt(liste.size()+1);
		
			if (i == 0)
				return null;
		} while(i < 0 && i >= liste.size());
		 
		return liste.get(i-1);
	
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Le joueur";
	}
}
