package action;

import character.Monster;
import character.Player;
import game.Direction;
import game.Room;

public class Look extends Action {
	
	protected Room roomToLook;
	
	public Look(Room currentRoom,Direction d) {
		// TODO Auto-generated constructor stub
		super(currentRoom);
		roomToLook = currentRoom.getNeighboors(d);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if(roomToLook.getlMonsters().isEmpty())
			System.out.println("Aucun monstre dans cette salle");
		else 
			System.out.println("Il y a " + roomToLook.getlMonsters().size() + " monstres dans la salle");
		
		if(roomToLook.getlItems().isEmpty())
			System.out.println("Aucun objet dans la salle");
		else
			System.out.println("Il y a " + roomToLook.getlItems().size() + " objets dans la salle");
			
			
	}

	@Override
	public boolean isPossible(Player p) {
		// TODO Auto-generated method stub
		if(roomToLook != null) {
			p.addAction(this);
			return true;
		}
		return false;
	}

}
