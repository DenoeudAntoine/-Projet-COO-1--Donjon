

package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import character.Player;
import game.Direction;
import game.ExitRoom;
import game.Game;
import game.Room;

public class Main {
	
	public static void main(String[] args) {
		Player player = new Player(100, 100, 100);
		Game game = new Game(player);
	}
	

}
