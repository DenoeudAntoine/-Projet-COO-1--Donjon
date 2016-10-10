package game;

import item.*;

import java.util.*;
import character.*;

public class Room {
	/**
	 * lMonsters attribute corresponding to all monsters of this room
	 */
	protected List<Monster> lMonsters = new ArrayList<Monster>();
	
	/**
	 * lItems attribute corresponding to all items of this room
	 */
	protected List<Item> lItems = new ArrayList<Item>();
	
	/**
	 * neighboors attribute corresponding to all neighboors of this room
	 */
	protected Map<Direction,Room> neighboors = new HashMap<Direction,Room>();
	
	/**
	 * description attribute corresponding to the description of this room
	 */
	private String description;
	
	/**
	 * Room constructor
	 * @param description - Room's description
	 */
	public Room(String description) {
		this.description = description;
	}
	
	
	/**
	 * lMonsters getter
	 * @return monster's list
	 */
	public List<Monster> getlMonsters() {
		return lMonsters;
	}
	
	
	/**
	 * lItems getter
	 * @return item's list
	 */
	public List<Item> getlItems() {
		return lItems;
	}
	
	
	/**
	 * This method permit to add a monster in lMonsters
	 * @param m - The monster to add
	 * @return true if insertion was successful / false otherwise
	 */
	public boolean addMonster(Monster m) {
		return lMonsters.add(m);
	}
	
	
	/**
	 * This method permit to remove a monster in lMonsters
	 * @param m - The monster to remove
	 * @return true if remove was successful / false otherwise
	 */
	public boolean removeMonster(Monster m) {
		return lMonsters.remove(m);
	}
	
	
	/**
	 * This method permit to add a item in lItems
	 * @param i - The item to add
	 * @return true if insertion was successful / false otherwise
	 */
	public boolean addItem(Item i) {
		return lItems.add(i);
	}
	
	
	/**
	 * This method permit to remove a item in lItems
	 * @param i - The object to remove
	 * @return true if remove was successful / false otherwise
	 */
	public boolean removeItem(Item i) {
		return lItems.remove(i);
	}
	
	
	/**
	 * This method retrieves a room depending on the direction parameter
	 * @param d - The direction
	 * @return the corresponding room
	 */
	public Room getNeighboors(Direction d) {
		return neighboors.get(d);
	}
	
	
	/**
	 * This method permit to add a neighboor to a room
	 * @param d - The neighbor's direction
	 * @param r - The adjoining room
	 */
	public void addNeighbors(Direction d, Room r) {
		neighboors.put(d,r);
	}
	
	
	/**
	 * description getter
	 * @return Room's description
	 */
	public String getDescription() {
		return this.description;
	}
	
	
	/**
	 * This method permit to make difference with ExitRoom
	 * @return false 
	 */
	public boolean isExit() {
		return false;
	}
	
	
	/**
	 * This method permit to get a list of possible direction
	 * @return direction's list
	 */
	public List<Direction> verifDirection() {
		List<Direction> lDirection = new ArrayList<Direction>();
				
		for(Direction d : neighboors.keySet())
			lDirection.add(d);
		return lDirection;
	}
	
	
	/**
	 * This method permit to add all neighbors to a room
	 * @param nextRoom - The next room
	 * @param i - Index of the line
	 * @param j - Index of the column
	 * @param tmpList - A temporay list of Room, permit to add North and South neighbors of the current room
	 * @param taille - Size of dungeon
	 * @return tmpList
	 */
	public <T extends Room> List<Room> addAllNeighboors(T nextRoom, int i, int j, List<Room> tmpList, int taille) {
		//No neighbor to the East for the last column
		if(i != taille - 1) {
			//Add East neighbor
			this.addNeighbors(Direction.Est, nextRoom);
		
			//Add West neighbor
			nextRoom.addNeighbors(Direction.Ouest, this);
		}
		
		//No neighbor to the North for the first line
		if(j != 0) {
			//Add North neighbor thank to tmpList
			this.addNeighbors(Direction.Nord, tmpList.get(i));
			
			//Add South neighbor thank to tmpList
			tmpList.get(i).addNeighbors(Direction.Sud, this);
			
			//Added the room in the list at the right index
			tmpList.set(i, this);
		}
		else {
			//Added the room in the list
			tmpList.add(this);
		}
		
		return tmpList;
	}
}
