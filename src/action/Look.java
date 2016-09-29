package action;

import character.Monster;
import character.Player;
import game.Direction;
import game.Room;

public class Look extends Action {
	
	protected Room currentRoom;
	protected Room room;
	
	public Look(Room currentRoom,Direction d) {
		// TODO Auto-generated constructor stub
		this.currentRoom = currentRoom;
		room = currentRoom.getNeighboors(d);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if(room.getlMonsters().isEmpty())
			System.out.println("Aucun monstre dans cette salle");
		else 
			System.out.println("Il y a " + room.getlMonsters().size() + " monstres dans la salle");
		
		if(room.getlItems().isEmpty())
			System.out.println("Aucun objet dans la salle");
		else
			System.out.println("Il y a " + room.getlItems().size() + " objets dans la salle");
			
			
	}

	@Override
	public boolean isPossible(Player p) {
		// TODO Auto-generated method stub
		if(room != null) {
			p.addAction(this);
			return true;
		}
		return false;
	}

}
