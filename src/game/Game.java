package game;

import item.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import action.*;
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
		Attack attack = new Attack(this);
		if(attack.isPossible())
			p.addAction(attack);
		
		Look look = new Look(this);
		if(look.isPossible())
			p.addAction(look);
		
		Move move = new Move(this);
		if(move.isPossible())
			p.addAction(move);
		
		Use use = new Use(this);
		if(use.isPossible())
			p.addAction(use);
		
		p.act();
		
	}
	
	public boolean isFinished() {
		if(player.getHP() > 0)
			return false;
		return true;
	}
	
	public void playerMoveTo(Direction d) {
		this.currentRoom = currentRoom.getNeighboors(d);
	}
	
	public void addItems(Room room) {
		room.addItem(new Gold());
		room.addItem(new HealthPotion());
		room.addItem(new StrengthPotion());
	}
	
	public void addMonsters(Room room) {
		room.addMonster(new Monster(1, 2, 3) );
		room.addMonster(new Monster(1, 2, 3));
		room.addMonster(new Monster(1, 2, 3));
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
		
		this.addItems(tmpRoom);
		this.addMonsters(tmpRoom);
		
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
					this.addItems(tmpRoom);
					this.addMonsters(tmpRoom);
				}
				else {
					//Gestion cas aucune sortie générée
					//A optimiser !
					if(nbSortie == 0 && j == taille - 1 && i == taille - 1) {
						ExitRoom nextRoom = new ExitRoom("Salle " + (indice+1));
						tmpList = tmpRoom.addAllNeighboors(nextRoom, i, j, tmpList, taille);
						tmpRoom = nextRoom;
						this.addItems(tmpRoom);
						this.addMonsters(tmpRoom);
					}
					else {
						Room nextRoom = new Room("Salle " + (indice+1));		
						tmpList = tmpRoom.addAllNeighboors(nextRoom, i, j, tmpList, taille);
						tmpRoom = nextRoom;
						this.addItems(tmpRoom);
						this.addMonsters(tmpRoom);
					}					
				}
				indice ++;
			}			
		}
	}
}
