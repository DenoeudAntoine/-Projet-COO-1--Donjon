package action;

import character.Player;
import game.Direction;
import game.Room;

public class Move extends Action {

	public Move(Room currentRoom,Direction d) {
		// TODO Auto-generated constructor stub
		super(currentRoom);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPossible(Player p) {
		// TODO Auto-generated method stub
		return true;
	}

}
