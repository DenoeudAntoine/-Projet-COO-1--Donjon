package action;

import character.Player;
import game.Room;
import item.Item;

public class Use extends Action {
	
	protected Item item;
	
	public Use(Room currentRoom, Item item) {
		// TODO Auto-generated constructor stub
		super(currentRoom);
		this.item = item;
	}

	@Override
	public void execute(Player p) {
		// TODO Auto-generated method stub
		System.out.println("L'objet " + item + "va vous affecter !");
		item.effect(p);
		
	}

	@Override
	public boolean isPossible() {
		// TODO Auto-generated method stub
		if (item.isPossible())
			return true;
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Utiliser " + item;
	}

}
