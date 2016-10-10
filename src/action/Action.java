package action;

import character.Player;
import game.Game;
import game.Room;

public abstract class Action {
	/**
	 * Game attribute corresponding to currently game
	 */
	protected Game game;
	
	/**
	 * Action constructor
	 * @param game - Currently game
	 */
	public Action(Game game){
		this.game = game;;
	}
	
	
	/**
	 * This method permit to execute a action
	 * @param p
	 */
	public abstract void execute(Player p);
	
	
	/**
	 * This method permit to check if one action is possible
	 * @return true if the action is possible / false otherwise
	 */
	public abstract boolean isPossible();
	
	public abstract String toString();
	
	
}
