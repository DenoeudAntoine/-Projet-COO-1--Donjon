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
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Tu vas être déplacé");
		g.playerMoveTo(d);
	}

	@Override
	public boolean isPossible(Player p) {
		// TODO Auto-generated method stub
		if ( currentRoom.getNeighboors(d) != null) {
			p.addAction(this);
			return true;
		}
			
		return false;
	}

}
