package test;

import static org.junit.Assert.*;

import org.junit.*;

import action.Action;
import action.Look;

public class testLook extends testAction {

	@Override
	public Action initAction() {
		// TODO Auto-generated method stub
		return new Look(g);
	}

	@Override
	@Test
	public void testIsPossible() {
		// TODO Auto-generated method stub
		assertTrue(a.isPossible());
		g.setCurrentRoom(null);
		
		assertFalse(a.isPossible());
		
	}

}
