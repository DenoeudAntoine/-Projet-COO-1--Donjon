

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
		int i = 0;
        while(!game.isFinished()) {
			System.out.println("\n#############################");
			System.out.println("            Tour "+i);
			System.out.println("#############################\n");
        	System.out.println("\n\n"+ player );
						
			game.play(player);
			player.removeAll();
			
			System.out.println("\n");
			i++;
		}
	}
	

}
