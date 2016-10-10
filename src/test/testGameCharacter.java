package test;

import org.junit.Before;

import character.GameCharacter;

public abstract class testGameCharacter {
	
	/**
	 * A game character
	 */
	protected GameCharacter g1;
	
	/**
	 * Initialize the game character
	 */
	@Before
	public void init(){
		g1 = initGC();
	}

	/**
	 * Initialize the game character according to the test
	 * @return
	 */
	protected abstract GameCharacter initGC();
	
	/**
	 * Test the method isAttacked
	 */
	public abstract void testIsAttacked();
	
	
}
