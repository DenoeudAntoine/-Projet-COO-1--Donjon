package game;

import item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import character.Monster;
import character.Player;

public class Game {
	
	private Room currentRoom;
	private Player player;
	
	
	public Game() {
		// TODO Auto-generated constructor stub
	}
	
	public Game(Player player){
		this.createMap();
		this.player = player;
	
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void play(Player p) {
	
		
	}
	
	public boolean isFinished() {
		return true;
	}
	
	public void playerMoveTo(Direction d) {
		this.currentRoom = currentRoom.getNeighboors(d);
	}
	
	public void createMap() {
		List <Room> tmpList = new ArrayList<Room>();
		
		Room tmpRoom;
		
		int taille = 5, i = 0;
		int indice = 1;
		int probaSortie;
		int nbSortie = 0;
		Random r = new Random();
		
		//Création première salle
		tmpRoom = new Room("Salle 1");
		this.currentRoom = tmpRoom;
		
		
		
		for(int j = 0 ; j < taille ; j++) {
			
			for(i = 0 ; i < taille ; i++) {
				//Création de la salle suivante
				//Création aléatoire des salles de sorties
				probaSortie = r.nextInt(100);
				if(probaSortie > 100) {
					ExitRoom nextRoom = new ExitRoom("Salle " + (indice+1));
					nbSortie++;
					
					tmpList = tmpRoom.addAllNeighboors(nextRoom, i, j, tmpList, taille);
					tmpRoom = nextRoom;
				}
				else {
					//Gestion cas aucune sortie générée
					//A optimiser !
					if(nbSortie == 0 && j == taille - 1 && i == taille - 1) {
						ExitRoom nextRoom = new ExitRoom("Salle " + (indice+1));
						tmpList = tmpRoom.addAllNeighboors(nextRoom, i, j, tmpList, taille);
						tmpRoom = nextRoom;
					}
					else {
						Room nextRoom = new Room("Salle " + (indice+1));		
						tmpList = tmpRoom.addAllNeighboors(nextRoom, i, j, tmpList, taille);
						tmpRoom = nextRoom;
					}					
				}
				indice ++;
			}			
		}
	}
}
