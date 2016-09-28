package game;

import item.Item;
import character.Monster;
import character.Player;

public class Game {
	
	private Room currentRoom;
	private Player player;
	
	public Game() {
		// TODO Auto-generated constructor stub
	}
	
	public Game(Room currentRoom, Player player){
		this.currentRoom = currentRoom;
		this.player = player;
	
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void play(Player p) {
		if(this.currentRoom.lMonsters.isEmpty() && this.currentRoom.lItems.isEmpty()) {
			
		}
		
	}
	
	public boolean addMonster(Monster monster, Room room){
		return true;
	}
	
	public boolean addItem(Item item,Room room) {
		return true;
	}
	
	public boolean isFinished() {
		return true;
	}
	
	public void playerMoveTo(Direction d) {
		this.currentRoom = currentRoom.getNeighboors(d);
	}
	
	

}
