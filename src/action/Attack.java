package action;

import character.Monster;
import character.Player;
import game.Room;

public class Attack extends Action {
	
	protected Monster monster;
	protected Player player;
	
	public Attack(Room currentRoom,Monster monster,Player player) {
		super(currentRoom);
		// TODO Auto-generated constructor stub
		this.monster = monster;
		this.player = player;
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
