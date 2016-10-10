package action;

import character.Player;
import game.Direction;
import game.Game;
import game.Room;

public class Move extends Action {
	/**
	 * Move constructor
	 * @param game - Currently game
	 */
	public Move(Game game) {
		super(game);
	}
	
	
	/**
	 * This method permit to changing room
	 * @param p - Player
	 */
	@Override
	public void execute(Player p) {
		Direction d = p.chose(game.getCurrentRoom().verifDirection());
		System.out.println("Tu vas etre deplace");
		game.playerMoveTo(d);
	}
	
	
	/**
	 * This method permit to check if there are still monsters in the room before moving
	 * @return true if is possible / false otherwise
	 */
	@Override
	public boolean isPossible() {
		if(game.getCurrentRoom().getlMonsters().isEmpty())
			return true;
			
		return false;
	}

	@Override
	public String toString() {
		return "Action move";
	}

}
