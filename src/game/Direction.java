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
	
	public static Direction getOpposite(Direction d) {
		switch(d){
		case Nord:
			return Sud;
		case Sud :
			return Nord;
		case Est:
			return Ouest;
		case Ouest:
			return Est;
		}
		return null;
	}
}
