package action;

import character.Player;
import game.Room;

public abstract class Action {
	
	protected Room currentRoom;
	
	public Action(Room room){
		this.currentRoom = room;
	}
	
	public String toString() {
		return "slt";
	}
	
	public abstract void execute();
	
	public abstract boolean isPossible(Player p);
}
