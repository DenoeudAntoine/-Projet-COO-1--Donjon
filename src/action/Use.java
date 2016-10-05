package action;

import character.Player;
import game.Game;
import game.Room;
import item.Item;

public class Use extends Action {
		
	public Use(Game game) {
		// TODO Auto-generated constructor stub
		super(game);
	}

	@Override
	public void execute(Player p) {
		
		// choisir un item parmi les itesm de la piece
		Item item = p.chose(game.getCurrentRoom().getlItems());
		// TODO Auto-generated method stub
		System.out.println("L'objet " + item + "va vous affecter !");
		item.effect(p);
		
		game.getCurrentRoom().removeItem(item);
		
	}

	@Override
	public boolean isPossible() {
		// ? this.game.getCurrentRoom().litems est vide ?
		// TODO Auto-generated method stub
		if (game.getCurrentRoom().getlItems().isEmpty())
			return false;
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Action use";
	}

}
