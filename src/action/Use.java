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
		
		// TODO Auto-generated method stub
		System.out.println("L'objet " + item + "va vous affecter !");
		item.effect(p);
		
	}

	@Override
	public boolean isPossible() {
		// ? this.game.getCurrentRoom().litems est vide ?
		// TODO Auto-generated method stub
		if (item.isPossible())
			return true;
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Utiliser " + item;
	}

}
