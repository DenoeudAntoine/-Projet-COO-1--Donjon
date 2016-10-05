package action;

import character.Monster;
import character.Player;
import game.Direction;
import game.Game;
import game.Room;

public class Look extends Action {
	
	public Look(Game game) {
		// TODO Auto-generated constructor stub
		super(game);
	}

	@Override
	public void execute(Player p) {
		// TODO Auto-generated method stub
		if(game.getCurrentRoom().getlMonsters().isEmpty())
			System.out.println("Aucun monstre dans cette salle");
		else 
			System.out.println("Il y a " + game.getCurrentRoom().getlMonsters().size() + " monstres dans la salle");
		
		if(game.getCurrentRoom().getlItems().isEmpty())
			System.out.println("Aucun objet dans la salle");
		else
			System.out.println("Il y a " + game.getCurrentRoom().getlItems().size() + " objets dans la salle");
		
		for(Direction d : Direction.getAllDirection()) {
			if(game.getCurrentRoom().getNeighboors(d) != null) {
				System.out.println("Une salle est pr�sente " + d.toString(d));
			}
		}
			
	
			
	}

	@Override
	public boolean isPossible() {
		// TODO Auto-generated method stub
		if(game.getCurrentRoom() != null) 
			return true;
		
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Regarder dans la salle";
	}

}
