package action;

import character.GameCharacter;
import character.Player;
import game.Room;

public class Attack extends Action {
	
	protected GameCharacter attacker;
	protected GameCharacter target;
	
	public Attack(Room currentRoom,GameCharacter attacker,GameCharacter target) {
		super(currentRoom);
		// TODO Auto-generated constructor stub
		this.attacker = attacker;
		this.target = target;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Le personnage " + attacker + " attaque " + target );
		System.out.println(target + " perd " + attacker.getStrength() +" points de vie ");
	}

	@Override
	public boolean isPossible(Player p) {
		// TODO Auto-generated method stub
		return true;
		
	}

}
