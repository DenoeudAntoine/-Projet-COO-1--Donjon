package test;

import org.junit.Before;

import character.GameCharacter;

public abstract class testGameCharacter {
	
	protected GameCharacter g1;
	
	
	@Before
	public void init(){
		g1 = initGC();
	}


	protected abstract GameCharacter initGC();
	
	
	public abstract void testIsAttacked();
	
	
}
