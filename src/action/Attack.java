package action;

import character.GameCharacter;
import character.Monster;
import character.Player;
import game.Game;
import game.Room;

public class Attack extends Action {
	/**
	 * Attack constructor
	 * @param game - Currently game
	 */	
	public Attack(Game game) {
		super(game);
	}
	
	
	/**
	 * This method permit to attack a monster
	 * @param p - Player
	 */
	@Override
	public void execute(Player p) {
		Monster target = p.chose(game.getCurrentRoom().getlMonsters());
		target.isAttacked(p);
		p.isAttacked(target);
		
		if(target.getHP() <= 0){
			System.out.println("Le monstre a été tué");
			p.addGolds(target.getCoins());
			game.getCurrentRoom().removeMonster(target);
		}
	}
	
	
	/**
	 * This method permit to check if one attack is possible
	 * @return true if there is at least 1 monster / false otherwise
	 */
	@Override
	public boolean isPossible() {
		if(!game.getCurrentRoom().getlMonsters().isEmpty())
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Action attack";
	}

}
