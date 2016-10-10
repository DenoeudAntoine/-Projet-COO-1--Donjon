package action;

import character.Monster;
import character.Player;
import game.Direction;
import game.Game;
import game.Room;

public class Look extends Action {
	/**
	 * Look constructor
	 * @param game - Currently game
	 */
	public Look(Game game) {
		super(game);
	}
	
	
	/**
	 * This method permit to have informations about the room
	 * @param p - Player
	 */
	@Override
	public void execute(Player p) {
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
				System.out.println("Une salle est presente " + d.toString(d));
			}
		}		
	}
	
	
	/**
	 * This method permit to check if the action look is possible
	 * @return true if is possible / false otherwise
	 */
	@Override
	public boolean isPossible() {
		if(game.getCurrentRoom() != null) 
			return true;
		
		return false;
	}

	@Override
	public String toString() {
		return "Regarder dans la salle";
	}
}
