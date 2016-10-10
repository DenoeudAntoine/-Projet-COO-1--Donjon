package action;

import character.Player;
import game.Game;
import game.Room;
import item.Item;

public class Use extends Action {
	/**
	 * Use constructor
	 * @param game - Currently game
	 */
	public Use(Game game) {
		super(game);
	}
	
	
	/**
	 * This method permit to use a item
	 * @param p - Player
	 */
	@Override
	public void execute(Player p) {		
		//Choose a item among the item in the room
		Item item = p.chose(game.getCurrentRoom().getlItems());
		
		System.out.println("L'objet " + item + "va vous affecter !");
		item.effect(p);
		
		game.getCurrentRoom().removeItem(item);		
	}
	
	
	/**
	 * This method permit to check if there are still items in the room 
	 * @return true if there are still items in the room / false otherwise
	 */
	@Override
	public boolean isPossible() {
		if (game.getCurrentRoom().getlItems().isEmpty())
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Action use";
	}

}
