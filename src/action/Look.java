package action;

import character.Monster;
import character.Player;
import game.Direction;
import game.Room;

public class Look extends Action {
	
	public Look(Room currentRoom) {
		// TODO Auto-generated constructor stub
		super(currentRoom);
	}

	@Override
	public void execute(Player p) {
		// TODO Auto-generated method stub
		if(currentRoom.getlMonsters().isEmpty())
			System.out.println("Aucun monstre dans cette salle");
		else 
			System.out.println("Il y a " + currentRoom.getlMonsters().size() + " monstres dans la salle");
		
		if(currentRoom.getlItems().isEmpty())
			System.out.println("Aucun objet dans la salle");
		else
			System.out.println("Il y a " + currentRoom.getlItems().size() + " objets dans la salle");
		
		for(Direction d : Direction.getAllDirection()) {
			if(currentRoom.getNeighboors(d) != null) {
				System.out.println("Une salle est présente " + d.toString(d));
			}
		}
			
			
	}

	@Override
	public boolean isPossible() {
		// TODO Auto-generated method stub
		if(currentRoom != null) 
			return true;
		
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Regarder dans la salle";
	}

}
