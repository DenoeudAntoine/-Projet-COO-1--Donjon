package game;

import item.*;

import java.util.*;
import character.*;

public class Room {
	
	protected List<Monster> lMonsters = new ArrayList<Monster>();
	protected List<Item> lItems = new ArrayList<Item>();
	protected Map<Direction,Room> neighboors = new HashMap<Direction,Room>();
	public Room() {
		// TODO Auto-generated constructor stub
	}
	
	public Room getNeighboors(Direction d) {
		return neighboors.get(d);
	}
	
	public void addNeighboors(Direction d, Room m) {
		neighboors.put(d,m);
	}

}
