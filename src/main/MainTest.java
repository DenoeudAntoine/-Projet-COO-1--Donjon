

package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import game.Direction;
import game.Room;

public class MainTest {
	
	public static Room tmpRoom;
	public static Room salleTest;
	
	public static void main(String[] args) {
		List <Room> tmpList = new ArrayList<Room>();
		int taille = 5, i = 0;
		int indice = 1;
		
		//Création première salle
		tmpRoom = new Room("Salle 1");
		
		for(int j = 0 ; j < taille ; j++) {
			
			for(i = 0 ; i < taille ; i++) {
				//Création de la salle suivante
				Room nextRoom = new Room("Salle " + (indice+1));
								
				//Ajout voisin Est
				if(i != taille - 1) {
					tmpRoom.addNeighbors(Direction.Est, nextRoom);
				}
				
				//Ajout voisin Ouest
				if(i != taille - 1)
					nextRoom.addNeighbors(Direction.Ouest, tmpRoom);
				
				//Ajout voisin nord grâce à la liste
				if(j != 0)
					tmpRoom.addNeighbors(Direction.Nord, tmpList.get(i));
				
				//Récupération de la salle dans la liste pour ajouter la salle en cours en voisin
				if(j != 0)
					tmpList.get(i).addNeighbors(Direction.Sud, tmpRoom);
				
				//Ajout de la salle en cours dans la liste, au bon indice
				if(j == 0)
					tmpList.add(tmpRoom);
				else						
					tmpList.set(i, tmpRoom);
				
				//Test
				if(j == 3 && i == 3)
					salleTest = tmpRoom;
					
				tmpRoom = nextRoom;
				
				indice ++;
			
			}			
		}

		
		System.out.println("Salle en cours : " + salleTest.getDescription());
		
		
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
