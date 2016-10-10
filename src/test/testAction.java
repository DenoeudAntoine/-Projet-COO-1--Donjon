package test;
import org.junit.*;

import action.*;
import character.Player;
import game.Game;
import game.Room;

public abstract class testAction {
	protected Game g;
	protected Player p;
	protected Action a;
	protected Room r;
	
	@Before
	public void init() {
		p = new Player(10, 10, 10);
		g = new Game(p);
		r = new Room("Salle de test");
		g.setCurrentRoom(r);
		a = initAction();
	}
	
	
	public abstract Action initAction();
	
	@Test
	public abstract void testIsPossible();
	
}
