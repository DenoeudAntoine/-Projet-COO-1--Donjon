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
	 * @param m - The adjoining room
	 */
	public void addNeighboors(Direction d, Room m) {
		neighboors.put(d,m);
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

	public List<Direction> verifDirection() {
		List<Direction> lDirection = new ArrayList<Direction>();
				
		for(Direction d : neighboors.keySet())
			lDirection.add(d);
		return lDirection;

	}
	
	
	public <T extends Room> List<Room> addAllNeighboors(T nextRoom, int i, int j, List<Room> tmpList, int taille) {
		if(i != taille - 1) {
			//Ajout voisin Est
			this.addNeighboors(Direction.Est, nextRoom);
		
			//Ajout voisin Ouest
			nextRoom.addNeighboors(Direction.Ouest, this);
		}
		
		
		if(j != 0) {
			//Ajout voisin nord grâce à la liste
			this.addNeighboors(Direction.Nord, tmpList.get(i));
			
			//Ajout voisin sud pour la salle du dessus
			tmpList.get(i).addNeighboors(Direction.Sud, this);
			
			//Ajout de la salle dans la liste au bon indice
			tmpList.set(i, this);
		}
		else {
			//Ajout de la salle dans la liste
			tmpList.add(this);
		}
				
		
		return tmpList;
	}
}
