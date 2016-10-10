package test;
import org.junit.*;

import action.*;
import character.Player;
import game.Game;
import game.Room;

public abstract class testAction {
	/**
	 * Current game
	 */
	protected Game g;
	
	/**
	 * Player of the game
	 */
	protected Player p;
	
	/**
	 * Action to test
	 */
	protected Action a;
	
	/**
	 * Current room
	 */
	protected Room r;
	
	
	/**
	 * initialize the variables
	 */
	@Before
	public void init() {
		p = new Player(10, 10, 10);
		g = new Game(p);
		r = new Room("Salle de test");
		g.setCurrentRoom(r);
		a = initAction();
	}
	
	/**
	 * Initialize the action
	 * @return the action
	 */
	public abstract Action initAction();
	
	
	/**
	 * Test the method if possible
	 */
	@Test
	public abstract void testIsPossible();
	
}
