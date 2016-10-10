package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import character.Monster;
import game.Room;
import item.HealthPotion;
import item.Item;

public class testRoom {
	
	Room r;
	
	@Before
	public void init(){
		r = new Room("salle de test");
	}
	
	@Test
	public void testAddRemoveMonster() {
		assertTrue(r.getlMonsters().isEmpty());
		Monster m = new Monster(10, 10, 0);
		r.addMonster(m);
		
		assertFalse(r.getlMonsters().isEmpty());
		assertEquals(r.getlMonsters().get(0),m);
		
		r.removeMonster(m);
		
		assertTrue(r.getlMonsters().isEmpty());
	}
	
	@Test
	public void testAddRemoveItem() {
		assertTrue(r.getlItems().isEmpty());
		
		Item i = new HealthPotion();
		
		r.addItem(i);
		
		assertFalse(r.getlItems().isEmpty());
		assertEquals(r.getlMonsters().get(0),i);
		
		r.removeItem(i);
		
		assertTrue(r.getlItems().isEmpty());
	}
}
