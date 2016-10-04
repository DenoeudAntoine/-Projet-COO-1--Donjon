

package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import game.Direction;
import game.ExitRoom;
import game.Room;

public class Main {
	
	static Room salleTest = new Room("slt");
	static Room tmpRoom;
	
	
	
	
	
	static public <T extends Room> List<Room> ajouter(T nextRoom, int i, int j, List<Room> tmpList, int taille) {
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
			
		if(i == 3 && j == 2) {
			salleTest = tmpRoom;
		}
		tmpRoom = nextRoom;
		
		
		return tmpList;
	}
		
	
	
	
	
	public static void main(String[] args) {
		List <Room> tmpList = new ArrayList<Room>();

		
		int taille = 5, i = 0;
		int indice = 1;
		int probaSortie;
		int nbSortie = 0;
		Random r = new Random();
		
		//Création première salle
		tmpRoom = new Room("Salle 1");
		
		
		
		
		for(int j = 0 ; j < taille ; j++) {
			
			for(i = 0 ; i < taille ; i++) {
				//Création de la salle suivante
				//Création aléatoire des salles de sorties
				probaSortie = r.nextInt(100);
				if(probaSortie > 92) {
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
					
					
					
					tmpList = ajouter(nextRoom, i, j, tmpList, taille);
				}
				else {
					//Gestion cas aucune sortie générée
					//A optimiser !
					if(nbSortie == 0 && j == taille - 1 && i == taille - 1) {
						ExitRoom nextRoom = new ExitRoom("Salle " + (indice+1));
						tmpList = ajouter(nextRoom, i, j, tmpList, taille);
					}
					else {
						Room nextRoom = new Room("Salle " + (indice+1));		
						tmpList = ajouter(nextRoom, i, j, tmpList, taille);
					}					
				}
				indice ++;
			}			
		}
		
		System.out.println(salleTest.getDescription());
		
		
		//Affichage salle Sud
		try {
			System.out.println("Salle au Sud : " + salleTest.getNeighboors(Direction.Sud).getDescription());
		} catch (Exception e) {
			System.out.println("Pas de salle au Sud");
		}
		
		//Affichage salle Nord
		try {
			System.out.println("Salle au Nord : " + salleTest.getNeighboors(Direction.Nord).getDescription());
		} catch (Exception e) {
			System.out.println("Pas de salle au Nord");
		}
		
		//Affichage salle Est
		try {
			System.out.println("Salle a l'Est : " + salleTest.getNeighboors(Direction.Est).getDescription());
		} catch (Exception e) {
			System.out.println("Pas de salle à l'Est");
		}
		
		//Affichage salle Ouest
		try {
			System.out.println("Salle a l'Ouest : " + salleTest.getNeighboors(Direction.Ouest).getDescription());
		} catch (Exception e) {
			System.out.println("Pas de salle à l'Ouest");
		}
		
	}
	

}
