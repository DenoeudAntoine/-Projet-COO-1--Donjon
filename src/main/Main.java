

package main;

import character.Player;

import game.Game;


public class Main {
	
	public static void main(String[] args) {
		Player player = new Player(20, 4, 0);
		Game game = new Game(player);
		game.createMap();
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
