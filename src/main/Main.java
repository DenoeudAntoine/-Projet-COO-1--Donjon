package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import character.Player;
import game.Direction;
import game.Game;
import game.Room;

public class Main {

	public static void main(String[] args) {
		//Afficher le début du jeu
		Player p = new Player(10, 10, 10);
		Room room = new Room();
		int nbVoisins = 0;
		int nbSalles = 10;
		Stack<Room> pile = new Stack<Room> ();
		Game game = new Game(room, p);
	while(nbSalles > 0 ) {
			Random r= new Random();
			nbVoisins = r.nextInt(4) + 1 ;
			List<Direction> lDirection = new ArrayList<Direction>();
			for(int i = 0;i<nbVoisins;i++) {
				lDirection = room.verifDirection();
				int j = r.nextInt(lDirection.size());
				Room tmp = new Room();
				room.addNeighboors(lDirection.get(j), tmp);
				tmp.addNeighboors(Direction.getOpposite(lDirection.get(j)), room);
				pile.push(tmp);
				nbSalles--;
			}
			room = pile.pop();
		}
	
	
	}

}
