

package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import game.Direction;
import game.Room;

public class Main {
	
	public static Room tmpRoom;
	public static int indice = 1;
	public static Room salleTest;
	
	public static void main(String[] args) {
			List <Room> tmpList = new ArrayList<Room>();
			int taille = 5, i = 0;
			
			//Création première salle
	tmpRoom = new Room("Salle 1");
	
	for(int j = 0 ; j < taille ; j++) {
		
		//Création première ligne
		if(j == 0) {
			for(i = 0 ; i < taille ; i++) {
				
				//Création de la salle suivante
				Room nextRoom = new Room("Salle " + (indice+1));
								
				
				tmpRoom.addNeighboors(Direction.Est, nextRoom);
				tmpList.add(tmpRoom);
				
				nextRoom.addNeighboors(Direction.Ouest, tmpRoom);
				tmpRoom = nextRoom;
				
				//Ajout de la dernière colonne
				if (i == taille - 1) {
					tmpList.add(tmpRoom);							
				}						
				indice ++;
			}
		}
		else {
			for(i = 0 ; i < taille ; i++) {
				//Création de la salle suivante
				Room nextRoom = new Room("Salle " + (indice+1));
								
				//Ajout voisin Est
				if(i != taille - 1) {
					tmpRoom.addNeighboors(Direction.Est, nextRoom);
				}
				
				
				//Ajout voisin nord grâce à la liste
				tmpRoom.addNeighboors(Direction.Nord, tmpList.get(i));
				
				//Récupération de la salle dans la liste pour ajouter la salle en cours en voisin
				tmpList.get(i).addNeighboors(Direction.Sud, tmpRoom);
				
				//Ajout de la salle en cours dans la liste, au bon indice
				tmpList.set(i, tmpRoom);
				
				//Ajout voisin 
				nextRoom.addNeighboors(Direction.Ouest, tmpRoom);
				
				//test
				if(j == 2 && i == 0)
					salleTest = tmpRoom;
					
				tmpRoom = nextRoom;
				
				//Ajout de la dernière colonne
				if (i == taille - 1) {
					tmpList.add(tmpRoom);							
				}	
				
				
				indice ++;
			}
		}
	}
	System.out.println("Salle en cours : " + salleTest.getDescription());
	System.out.println("Salle au Sud : " + salleTest.getNeighboors(Direction.Sud).getDescription());
	System.out.println("Salle au Nord : " + salleTest.getNeighboors(Direction.Nord).getDescription());
	System.out.println("Salle a l'Est : " + salleTest.getNeighboors(Direction.Est).getDescription());
	System.out.println("Salle a l'Ouest : " + salleTest.getNeighboors(Direction.Ouest).getDescription());
	
}
	

}
