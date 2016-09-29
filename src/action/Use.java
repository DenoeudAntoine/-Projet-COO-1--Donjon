package action;

import character.Player;
import game.Room;
import item.Item;

public class Use extends Action {
	
	protected Item item;
	protected Player player;
	
	public Use(Room currentRoom, Item item, Player player) {
		// TODO Auto-generated constructor stub
		super(currentRoom);
		this.item = item;
		this.player = player;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("L'objet " + item + "va vous affecter !");
		item.effect(player);
		
	}

	@Override
	public boolean isPossible(Player p) {
		// TODO Auto-generated method stub
		return true;
	}

}
