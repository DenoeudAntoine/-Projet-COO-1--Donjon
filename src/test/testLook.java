package test;

import static org.junit.Assert.*;

import org.junit.*;

import action.Action;
import action.Look;

public class testLook extends testAction {
	
	/**
	 * @see test.testAction
	 */
	@Override
	public Action initAction() {
		// TODO Auto-generated method stub
		return new Look(g);
	}
	
	/**
	 * @see test.testAction
	 */
	@Override
	@Test
	public void testIsPossible() {
		// TODO Auto-generated method stub
		assertTrue(a.isPossible());
		g.setCurrentRoom(null);
		
		assertFalse(a.isPossible());
		
	}

}
