

package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import action.Action;
import action.Look;
import action.Move;
import character.Monster;
import character.Player;
import game.Direction;
import game.ExitRoom;
import game.Game;
import game.Room;
import item.Gold;
import item.HealthPotion;
import item.StrengthPotion;

public class Main {
	
	public static void main(String[] args) {
		Player player = new Player(20, 4, 0);
		Game game = new Game(player);
		
		while(true) {
			game.getCurrentRoom().addMonster(new Monster(1, 2, 3) );
			game.getCurrentRoom().addMonster(new Monster(1, 2, 3));
			game.getCurrentRoom().addMonster(new Monster(1, 2, 3));
			
			game.getCurrentRoom().addItem(new Gold());
			game.getCurrentRoom().addItem(new HealthPotion());
			game.getCurrentRoom().addItem(new StrengthPotion());
			
			player.addAction(new Look(game.getCurrentRoom()));
			for(Direction d : game.getCurrentRoom().verifDirection()) 
				player.addAction(new Move(game, game.getCurrentRoom(),d));
			Action a = player.chose(player.getActions());
			
			a.execute(player);
			
			player.removeAll();
			
		}
	}
	

}
