package game;

import java.util.ArrayList;
import java.util.List;

public enum Direction {
	Nord,Sud,Est,Ouest;
	
	
	/**
	 * Create a direction list and add all direction in this list
	 * @return List of directions
	 */
	public static List<Direction> getAllDirection() {
		List<Direction> lDirection = new ArrayList<Direction> ();
		for(Direction d : Direction.values())
			lDirection.add(d);
		
		return lDirection;
	}
	
	
	/**
	 * Return a string from last direction parameter
	 * @param d - A direction
	 * @return A string on the direction
	 */
	public String toString(Direction d) {
		switch(d) {
		case Nord:
			return "au Nord.";
		case Sud:
			return "au Sud.";
		case Est:
			return "a l'Est.";
		case Ouest:
			return "a l'Ouest.";
		default:
			return "le gps est dans le brouillard.";
		}
	}
}
