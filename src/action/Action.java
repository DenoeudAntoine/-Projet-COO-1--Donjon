package action;

import character.Player;
import game.Game;
import game.Room;

public abstract class Action {
	
	protected Game game;
	
	public Action(Game game){
		this.game = game;;
	}
	
	public abstract String toString();
	
	public abstract void execute(Player p);
	
	public abstract boolean isPossible();
}
