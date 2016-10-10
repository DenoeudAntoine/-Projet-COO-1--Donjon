package test;
import org.junit.*;

import action.*;
import character.Player;
import game.Game;

public abstract class testAction {
	protected Game g;
	protected Player p;
	protected Action a;
	
	@Before
	public void init() {
		p = new Player(10, 10, 10);
		g = new Game(p);
		a = initAction();
	}
	
	
	public abstract Action initAction();
	
	@Test
	public abstract void testIsPossible();
	
	@Test
	public abstract void testExecute();
}
