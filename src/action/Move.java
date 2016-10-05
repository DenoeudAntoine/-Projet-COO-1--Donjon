package action;

import character.Player;
import game.Direction;
import game.Game;
import game.Room;

public class Move extends Action {

	
	public Move(Game game) {
		// TODO Auto-generated constructor stub
		super(game);
		
	}

	@Override
	public void execute(Player p) {
		// TODO Auto-generated method stub
		System.out.println("Tu vas �tre d�plac�");
		g.playerMoveTo(d);
	}

	@Override
	public boolean isPossible() {
		// TODO Auto-generated method stub
		for(Direction d : Direction.getAllDirection()) {
			if(game.getCurrentRoom().getNeighboors(d) != null)
				return true;
		}
		
			
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Aller dans la salle " + d;
	}

}
