package action;

import character.GameCharacter;
import character.Monster;
import character.Player;
import game.Game;
import game.Room;

public class Attack extends Action {
		
	public Attack(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Player p) {
		Monster target = p.chose(game.getCurrentRoom().getlMonsters());
		target.isAttacked(p);
		p.isAttacked(target);
		
		if(target.getHP() <= 0)
			game.getCurrentRoom().removeMonster(target);
	}

	@Override
	public boolean isPossible() {
		// TODO Auto-generated method stub
		if(!game.getCurrentRoom().getlMonsters().isEmpty())
			return true;
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Action attack";
	}

}
