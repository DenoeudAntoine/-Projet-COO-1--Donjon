package test;

import static org.junit.Assert.*;

import org.junit.*;

import action.*;
import character.Monster;
public class testAttack extends testAction {
	
	
	/**
	 * @see test.testAction
	 */
	@Override
	public Action initAction() {
		// TODO Auto-generated method stub
		return new Attack(g);
	}
	
	
	/**
	 * @see test.testAction
	 */
	@Test
	public void testIsPossible() {
		// TODO Auto-generated method stub
		
		assertFalse(a.isPossible());
		g.getCurrentRoom().addMonster(new Monster(10,10,10));
		
		assertTrue(a.isPossible());
	}


}
