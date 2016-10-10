package test;

import static org.junit.Assert.*;

import org.junit.*;

import action.*;
import character.Monster;
public class testAttack extends testAction {

	@Override
	public Action initAction() {
		// TODO Auto-generated method stub
		return new Attack(g);
	}

	@Test
	public void testIsPossible() {
		// TODO Auto-generated method stub
		
		assertFalse(a.isPossible());
		g.getCurrentRoom().addMonster(new Monster(10,10,10));
		
		assertTrue(a.isPossible());
	}

	@Override
	public void testExecute() {
		// TODO Auto-generated method stub
		
	}

}
