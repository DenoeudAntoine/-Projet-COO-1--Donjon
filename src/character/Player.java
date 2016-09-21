package character;

import item.Item;

import java.util.ArrayList;
import java.util.List;

import scanner.ScannerInt;

import action.Action;

public class Player extends GameCharacter {
	protected List<Item> lstItems = new ArrayList<Item>();
	
	protected List<Action> lActions = new ArrayList<Action>();
	
	public Player(int hp, int strength, int coins) {
		super(hp, strength, coins);
		// TODO Auto-generated constructor stub
	}
	
	public void act() {
		Action action = this.chooseAction();
		action.execute(this);
	}
	
	public void addAction(Action a) {
		lActions.add(a);
	}
	
	public Action chooseAction() {
		int i = 0;
		System.out.println("Veuillez choisir une action\n0 : return null");
		for(Action o : lActions)
			System.out.println( ++i + " : " + o);
		i = ScannerInt.readInt(lActions.size()+1);
		if (i == 0)
			 return null;
		 return lActions.get(i-1);
		
	}
	
	
}
