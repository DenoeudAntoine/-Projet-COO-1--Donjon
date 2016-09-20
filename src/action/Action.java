package action;

import character.Player;

public interface Action {
	
	public String toString();
	
	public void execute(Player p);
	
	public void isPossible();
}
