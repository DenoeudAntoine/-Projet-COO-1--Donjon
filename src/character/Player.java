package character;

import item.Item;

import java.util.ArrayList;
import java.util.List;

import scanner.ScannerInt;

import action.Action;

public class Player extends GameCharacter {
	/**
	 * lActions attribute corresponding to the action's list of character
	 */
	protected List<Action> lActions = new ArrayList<Action>();
	
	
	/**
	 * Player constructor
	 * @param hp - Character's life
	 * @param strength - Character's strength
	 * @param coins - Number of coins of character
	 */
	public Player(int hp, int strength, int coins) {
		super(hp, strength, coins);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * lActions getter
	 * @return action's list of character
	 */
	public List<Action> getActions() {
		return lActions;
	}
	
	
	/**
	 * Remove all actions in lActions
	 */
	public void removeAll() {
		lActions = new ArrayList<Action>();
	}
	
	
	/**
	 * Heal the player
	 * @param hp - Number of points to heal
	 */
	public void heal(int hp) {		
		this.hp += hp;
	}
	
	
	/**
	 * Add coins to the player
	 * @param coins - Number of coins to add
	 */
	public void addGolds(int coins){
		this.coins += coins;
	}
	
	
	/**
	 * Add strenght to the player
	 * @param strength - Number of strength's points to add
	 */
	public void addStregth(int strength) {
		this.strength += strength;
	}
		
	
	/**
	 * Permit to chose action in lActions and execute it
	 */
	public void act() {
		Action action = this.chose(lActions);
        	action.execute(this);
	}
	
	
	/**
	 * Add action in lActions
	 * @param a - Action to add
	 */
	public void addAction(Action a) {
		lActions.add(a);
	}
	
	
	/**
	 * Permit to show actions's list and get the chosen action
	 * @param liste - List that contains what to choose
	 * @return chosen object
	 */
	public <T> T chose(List <T> liste) {
		int i = 0;
		do {
			System.out.println("Veuillez choisir une action\n");
		
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
		return "Player 1 : " + hp + " HP / " + strength + "points de force / " + coins + " pieces d'or" ;
	}
}
