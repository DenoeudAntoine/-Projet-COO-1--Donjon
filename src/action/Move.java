package action;

import character.Player;
import game.Direction;
import game.Game;
import game.Room;

public class Move extends Action {

	protected Direction d;
	protected Game g;
	
	public Move(Game g, Room currentRoom,Direction d) {
		// TODO Auto-generated constructor stub
		super(currentRoom);
		this.d = d;
		this.g = g;
	}

	@Override
	public void execute(Player p) {
		// TODO Auto-generated method stub
		System.out.println("Tu vas être déplacé");
		g.playerMoveTo(d);
	}

	@Override
	public boolean isPossible() {
		// TODO Auto-generated method stub
		if ( currentRoom.getNeighboors(d) != null) 
			return true;
		
			
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Aller dans la salle " + d;
	}

}
