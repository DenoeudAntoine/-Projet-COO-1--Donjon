package test;

import static org.junit.Assert.*;

import org.junit.Test;

import action.Action;
import action.Use;
import character.Player;
import item.HealthPotion;
import item.Item;

public class testUse extends testAction {
	
	/**
	 * @see test.testAction
	 */
	@Override
	public Action initAction() {
		// TODO Auto-generated method stub
		return new Use(g);
	}
	
	/**
	 * @see test.testAction
	 */
	@Override
	@Test
	public void testIsPossible() {
		// TODO Auto-generated method stub
		assertFalse(a.isPossible());
		
		r.addItem(new HealthPotion());
		
		assertTrue(a.isPossible());
	}

}
