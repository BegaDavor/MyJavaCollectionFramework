package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import collection.BegaList;
import collection.BegaSet;

public class BegaSetTest {
	
	BegaSet<Integer> bSet;

	@Before
	public void setUp(){
		bSet = new BegaSet<>();
	}
	
	@Test
	public void shouldAddElementIfDoesnContains() {
		bSet.add(1);
		bSet.add(2);
		bSet.add(3);
		bSet.add(2);
		
		BegaList<Integer> bl = new BegaList<>();
		bl.add(1); bl.add(2); bl.add(3);		
		assertTrue(bSet.containsAll(bl));
	}
	
	@Test
	public void shouldAddAllElementIfDoesntContains() {
		
		BegaList<Integer> bl = new BegaList<>();
		bl.add(1); bl.add(2); bl.add(3);
		bSet.add(1);
		bSet.addAll(bl);
				
		assertTrue(bSet.containsAll(bl));
	}
	
	@Test
	public void shouldClearSet() {
		bSet.add(1); bSet.add(2);
		bSet.clear();
		assertTrue(bSet.isEmpty());
	}
	
	@Test
	public void shouldRemoveElement() {
		bSet.add(1); bSet.add(2);
		bSet.remove(2);
		assertFalse(bSet.contains(2));
	}

	@Test
	public void shouldReturnFalseIfElementDoesntContains() {
		bSet.add(1);
		assertFalse(bSet.contains(2));
	}
	
	@Test
	public void shouldReturnFalseIfDoesnContainsAllElements() {
		
		BegaList<Integer> bl = new BegaList<>();
		bl.add(1); bl.add(2); bl.add(3);
		bSet.addAll(bl);
		BegaList<Integer> bl2 = new BegaList<>();
		bl2.add(5); bl2.add(6); bl2.add(1);
				
		assertFalse(bSet.containsAll(bl2));
	}
	
	@Test
	public void shouldReturnFalseIfSetIsNotEmpty() {
		bSet.add(1);
		assertFalse(bSet.isEmpty());
	}
	
	@Test
	public void shouldReturnTrueThatSetIsEmptyWhenRemoveAllElements() {
		bSet.add(1); bSet.add(2);
		BegaList<Integer> list = new BegaList<>();
		list.add(1); list.add(2);
		bSet.removeAll(list);
		assertTrue(bSet.isEmpty());
	}
	
	@Test
	public void retainAllTest(){
		bSet.add(1); bSet.add(2);
		BegaList<Integer> list = new BegaList<>();
		list.add(3); list.add(7); list.add(5); list.add(1);
		bSet.retainAll(list);
		assertFalse(bSet.contains(2));
	}
	
	
	

}
