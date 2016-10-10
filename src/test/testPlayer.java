package test;

import static org.junit.Assert.*;

import org.junit.Test;

import character.GameCharacter;
import character.Monster;
import character.Player;

public class testPlayer extends testGameCharacter {

	@Override
	protected GameCharacter initGC() {
		// TODO Auto-generated method stub
		return new Player(10,10,10);
	}
	
	@Test
	@Override
	public void testIsAttacked() {
		// TODO Auto-generated method stub
		Monster m = new Monster(1, 1, 1);
		g1.isAttacked(m)
		assertEquals(g1.getHP(),9);

	}

}
