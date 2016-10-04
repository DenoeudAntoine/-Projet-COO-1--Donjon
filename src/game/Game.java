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
	private Room tmpRoom;
	
	public Game() {
		// TODO Auto-generated constructor stub
	}
	
	public Game(Player player){
		this.createMap();
		this.player = player;
	
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void play(Player p) {
		if(this.currentRoom.lMonsters.isEmpty() && this.currentRoom.lItems.isEmpty()) {
			
		}
		
	}
	
	public boolean addMonster(Monster monster, Room room){
		return true;
	}
	
	public boolean addItem(Item item,Room room) {
		return true;
	}
	
	public boolean isFinished() {
		return true;
	}
	
	public void playerMoveTo(Direction d) {
		this.currentRoom = currentRoom.getNeighboors(d);
	}
	
	public void createMap() {
		List <Room> tmpList = new ArrayList<Room>();

		
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
					
					int quotient = 0;
					int nbA = indice;
					while(5 <= nbA) {
						nbA = nbA - 5;
						quotient++;
					}
					System.out.println("Preparation salle de sortie n°"+(indice+1));
					System.out.println("Position x : " + (nbA));
					System.out.println("Position y : " + quotient);
					
					
					
					tmpList = addNeighboorsr(nextRoom, i, j, tmpList, taille);
				}
				else {
					//Gestion cas aucune sortie générée
					//A optimiser !
					if(nbSortie == 0 && j == taille - 1 && i == taille - 1) {
						ExitRoom nextRoom = new ExitRoom("Salle " + (indice+1));
						tmpList = addNeighboorsr(nextRoom, i, j, tmpList, taille);
						
						int quotient = 0;
						int nbA = indice;
						while(5 <= nbA) {
							nbA = nbA - 5;
							quotient++;
						}
						System.out.println("Preparation salle de sortie n°"+(indice+1));
						System.out.println("Position x : " + (nbA));
						System.out.println("Position y : " + quotient);
					}
					else {
						Room nextRoom = new Room("Salle " + (indice+1));		
						tmpList = addNeighboorsr(nextRoom, i, j, tmpList, taille);
					}					
				}
				indice ++;
			}			
		}
	}
	
	
	public <T extends Room> List<Room> addNeighboorsr(T nextRoom, int i, int j, List<Room> tmpList, int taille) {
		if(i != taille - 1) {
			//Ajout voisin Est
			tmpRoom.addNeighboors(Direction.Est, nextRoom);
		
			//Ajout voisin Ouest
			nextRoom.addNeighboors(Direction.Ouest, tmpRoom);
		}
		
		
		if(j != 0) {
			//Ajout voisin nord grâce à la liste
			tmpRoom.addNeighboors(Direction.Nord, tmpList.get(i));
			
			//Ajout voisin sud pour la salle du dessus
			tmpList.get(i).addNeighboors(Direction.Sud, tmpRoom);
			
			//Ajout de la salle dans la liste au bon indice
			tmpList.set(i, tmpRoom);
		}
		else {
			//Ajout de la salle dans la liste
			tmpList.add(tmpRoom);
		}
			
		
		tmpRoom = nextRoom;
		
		
		return tmpList;
	}
}
