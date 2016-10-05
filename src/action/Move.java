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
		Direction d = p.chose(game.getCurrentRoom().verifDirection());
		System.out.println("Tu vas �tre d�plac�");
		game.playerMoveTo(d);
	}

	@Override
	public boolean isPossible() {
		// TODO Auto-generated method stub
		if(game.getCurrentRoom().getlMonsters().isEmpty())
			return true;
			
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Action move";
	}

}
