package item;

import character.Player;

public interface Item {
	
	public String toString();
	
	public void effect(Player p);
	
	public boolean isPossible();
}
