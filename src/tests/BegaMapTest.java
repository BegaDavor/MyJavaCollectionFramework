package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import collection.BegaList;
import collection.BegaMap;
import collection.BegaSet;

public class BegaMapTest {
	
	BegaMap<Integer, String> map;

	@Before
	public void setUp() {
		
		map = new BegaMap<>();
	}
	
	@Test
	public void shouldClearMap() {
		map.put(1, "a"); map.put(2, "b");
		map.clear();
		assertTrue(map.isEmpty());
	}
	
	@Test
	public void shouldReturnTrueIfKeyContains() {
		map.put(1, "a"); map.put(2, "b");
		assertTrue(map.containsKey(1));
	}
	
	@Test
	public void shouldReturnFalseIfKeyDoesntContains() {
		map.put(1, "a"); map.put(2, "b");
		assertFalse(map.containsKey(3));
	}
	
	@Test
	public void shouldReturnTrueIfValueContains() {
		map.put(1, "a"); map.put(2, "b");
		assertTrue(map.containsValue("b"));
	}
	
	@Test
	public void souldReturnFalseIfValueDoesntContains() {
		map.put(1, "a"); map.put(2, "b");
		assertFalse(map.containsValue("c"));
	}
	
	@Test
	public void shouldReturnValue() {
		map.put(1, "a"); map.put(2, "b");
		assertEquals("b", map.get(2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionIfKeyDoesnContains() {
		map.put(1, "a"); map.put(2, "b");
		map.get(3);
	}
	
	@Test
	public void shouldThrowFalseIfMapDoesntEmpty() {
		map.put(1, "a");
		assertFalse(map.isEmpty());
	}
	
	@Test
	public void keySetTest() {
		map.put(1, "a"); map.put(2, "b");
		BegaSet<Integer> keys = new BegaSet<>();
		keys.add(1); keys.add(2);
		assertTrue(keys.containsAll(map.keySet()));
	}
	
	@Test
	public void shouldReturnNullIfKeyContains() {
		map.put(1, "a"); map.put(2, "b");
		assertEquals(null, map.put(1, "c"));
	}
	
	@Test
	public void shouldRemoveElement() {
		map.put(1, "a"); map.put(2, "b");
		map.remove(1);
		assertFalse(map.containsValue("a"));
	}
	
	@Test
	public void valuesTest() {
		map.put(1, "a"); map.put(2, "b");
		BegaList<String> list = new BegaList<>();
		list.add("a"); list.add("b");
		assertTrue(list.containsAll(map.values()));
	}
	
	
	

	

}
