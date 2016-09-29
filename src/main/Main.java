

package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import game.Direction;
import game.Room;

public class Main {
	
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
			
				//Test
				if(j == 0 && i == 4)
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
