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
		if(currentRoom.isExit() && currentRoom.getlMonsters().isEmpty()) {
			System.out.println("Tu as atteint une sortie !\nFin du jeu :)");
			return true;
		}
		if(player.getHP() <= 0){
			System.out.println("plus de pdv fdp");
			return true;
		}
			
		return false;
	}
	
	public void playerMoveTo(Direction d) {
		this.currentRoom = currentRoom.getNeighboors(d);
	}
	
	public void addItems(Room room) {
		Random r = new Random();
		int i = r.nextInt(3);
		for(int j = 0;j<i;j++){
			switch(r.nextInt(4)){
			case 0:
				room.addItem(new Gold());
				break;
			case 1:
				room.addItem(new HealthPotion());
				break;
			case 2:
				room.addItem(new StrengthPotion());
				break;
			case 3:
				room.addItem(new OneHarmedBandit());
				break;
			}
		}
		
		
		
	}
	
	public void addMonsters(Room room) {
		Random r = new Random();
		int i = r.nextInt(4);
		switch(i){
		case 1:
			room.addMonster(new Monster(r.nextInt(10)+10,r.nextInt(4)+3, 15) );
			break;
		case 2:
			room.addMonster(new Monster(r.nextInt(5)+7,r.nextInt(3)+2, 10) );
			room.addMonster(new Monster(r.nextInt(5)+7,r.nextInt(3)+2, 10) );
			break;
		case 3:
			room.addMonster(new Monster(r.nextInt(2)+5, r.nextInt(2)+1, 6) );
			room.addMonster(new Monster(r.nextInt(2)+5, r.nextInt(2)+1, 6) );
			room.addMonster(new Monster(r.nextInt(2)+5, r.nextInt(2)+1, 6) );
			break;
		}
		
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
				if(probaSortie > 92) {
					ExitRoom nextRoom = new ExitRoom("Salle " + (indice+1));
					nbSortie++;
					
					tmpList = tmpRoom.addAllNeighboors(nextRoom, i, j, tmpList, taille);
					tmpRoom = nextRoom;
					System.out.println("la sortie est j:" + j + " i:"+i);
				}
				else {
					//Gestion cas aucune sortie générée
					//A optimiser !
					if(nbSortie == 0 && j == taille - 1 && i == taille - 1) {
						ExitRoom nextRoom = new ExitRoom("Salle " + (indice+1));
						tmpList = tmpRoom.addAllNeighboors(nextRoom, i, j, tmpList, taille);
						tmpRoom = nextRoom;
						System.out.println("2la sortie est j:" + j + " i:"+i);
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
