package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import character.Monster;
import game.Direction;
import game.Room;
import item.HealthPotion;
import item.Item;

public class testRoom {
	
	/**
	 * Room to test
	 */
	Room r;
	
	/**
	 * Initialize the room
	 */
	@Before
	public void init(){
		r = new Room("salle de test");
	}
	
	/**
	 * Test the methods addMonster / getlMonsters / removeMonster
	 */
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
	
	/**
	 * Test the methods addItem / removeItem / getlItems
	 */
	@Test
	public void testAddRemoveItem() {
		assertTrue(r.getlItems().isEmpty());
		
		Item i = new HealthPotion();
		
		r.addItem(i);
		
		assertFalse(r.getlItems().isEmpty());
		assertEquals(r.getlItems().get(0),i);
		
		r.removeItem(i);
		
		assertTrue(r.getlItems().isEmpty());
	}
	
	/**
	 * Test the method addNeighbors
	 */
	@Test
	public void testAddNeighbors() {
		Room r1 = new Room("voisin");
		
		r.addNeighbors(Direction.Est, r1);
		
		assertEquals(r.getNeighboors(Direction.Est),r1);
		
		assertNull(r.getNeighboors(Direction.Sud));
	}
}
