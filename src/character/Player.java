package character;

import java.util.ArrayList;
import java.util.List;

import action.Action;

public class Player extends GameCharacter {
	
	protected List<Action> lActions = new ArrayList<Action>();
	
	public Player(int hp, int strength, int coins) {
		super(hp, strength, coins);
		// TODO Auto-generated constructor stub
	}
	
	public void act() {
		
	}
	
	public void addAction(Action a) {
		lActions.add(a);
	}
	
	public Action chooseAction() {
		return null;
	}

}
