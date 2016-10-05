package game;

import item.*;

import java.util.*;
import character.*;

public class Room {
	
	protected List<Monster> lMonsters = new ArrayList<Monster>();
	protected List<Item> lItems = new ArrayList<Item>();
	protected Map<Direction,Room> neighboors = new HashMap<Direction,Room>();
	private String description;
		
	public Room(String description) {
		this.description = description;
	}
	
	public Room() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Monster> getlMonsters() {
		return lMonsters;
	}

	public List<Item> getlItems() {
		return lItems;
	}

	public boolean addMonster(Monster m) {
		return lMonsters.add(m);
	}
	
	public boolean removeMonster(Monster m) {
		return lMonsters.remove(m);
	}
	
	public boolean addItem(Item i) {
		return lItems.add(i);
	}
	
	public boolean removeItem(Item i) {
		return lItems.remove(i);
	}
	
	
	public Room getNeighboors(Direction d) {
		return neighboors.get(d);
	}
	
	public void addNeighboors(Direction d, Room m) {
		neighboors.put(d,m);
	}
	
	public String getDescription() {
		return this.description;
}

	public boolean isExit() {
		return false;
	}

	/**
	 * Verifie si la direction est libre
	 * @param d
	 * @return true si la direction est libre / false sinon
	 */
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
