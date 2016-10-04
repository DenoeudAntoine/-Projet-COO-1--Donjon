package action;

import character.Player;
import game.Room;

public abstract class Action {
	
	protected Room currentRoom;
	
	public Action(Room room){
		this.currentRoom = room;
	}
	
	public abstract String toString();
	
	public abstract void execute(Player p);
	
	public abstract boolean isPossible();
}
