package game;

import java.util.ArrayList;
import java.util.List;

public enum Direction {
	Nord,Sud,Est,Ouest;
	
	public static List<Direction> getAllDirection() {
		List<Direction> lDirection = new ArrayList<Direction> ();
		for(Direction d : Direction.values())
			lDirection.add(d);
		
		return lDirection;
	}
	
	public String toString(Direction d) {
		switch(d) {
		case Nord:
			return "au Nord.";
		case Sud:
			return "au Sud.";
		case Est:
			return "� l'Est.";
		case Ouest:
			return "� l'Ouest.";
		default:
			return "le gps est dans le brouillard.";
				
		}
	}
	
 
}
