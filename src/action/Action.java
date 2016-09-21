package action;

import character.Player;

public abstract class Action {
	
	
	public String toString() {
		return "slt";
	}
	
	public abstract void execute(Player p);
	
	public abstract void isPossible();
}
