package action;

import character.Player;

public abstract class Action {
	
	
	public String toString() {
		return "slt";
	}
	
	public abstract void execute();
	
	public abstract boolean isPossible(Player p);
}
