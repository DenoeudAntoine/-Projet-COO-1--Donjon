package action;

import character.GameCharacter;
import character.Player;
import game.Room;

public class Attack extends Action {
	
	protected GameCharacter target;
	
	public Attack(Room currentRoom,GameCharacter target) {
		super(currentRoom);
		// TODO Auto-generated constructor stub
		this.target = target;
	}

	@Override
	public void execute(Player p) {
		target.isAttacked(p);
		p.isAttacked(target);
	}

	@Override
	public boolean isPossible() {
		// TODO Auto-generated method stub
		if(!currentRoom.getlMonsters().isEmpty())
			return true;
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Attaquer "  + target;
	}

}
