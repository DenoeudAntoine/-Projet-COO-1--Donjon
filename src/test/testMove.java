package test;

import static org.junit.Assert.*;

import org.junit.Test;

import action.Action;
import action.Move;
import character.Monster;

public class testMove extends testAction {
	
	/**
	 * @see test.testAction
	 */
	@Override
	public Action initAction() {
		// TODO Auto-generated method stub
		return new Move(g);
	}
	
	
	/**
	 * @see test.testAction
	 */
	@Override
	@Test
	public void testIsPossible() {
		// TODO Auto-generated method stub
		assertTrue(a.isPossible());
		
		g.getCurrentRoom().addMonster(new Monster(10, 10, 10));
		
		assertFalse(a.isPossible());
		
	}

}
