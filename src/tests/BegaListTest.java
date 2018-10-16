package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import collection.BegaList;

public class BegaListTest {

	BegaList<Integer> list;
	
	@Before
	public void setUp() {
		list = new BegaList<>();
	}
	
	@Test
	public void shouldAddElementInList() {
		Integer a = new Integer(1);
		Integer b = new Integer(2);
		Integer c = new Integer(3);
		
		list.add(a);
		list.add(b);
		list.add(c);
		
		assertTrue(list.contains(a));
		assertTrue(list.contains(b));
		assertTrue(list.contains(c));
	}
	
	@Test
	public void shouldAddElementOnIdex() {
		Integer a = 1; Integer b = 2; Integer c = 3; Integer d = 4;
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		
		list.add(2, 5);
		list.contains(5);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldThrowIndexOutOfBoundsExceptionIfTryAddElementOnIndexIsLowerThanZero() {
		list.add(-1, 3);
	}
	
	@Test
	public void shouldAddAllCollection() {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1); al.add(2); al.add(3);
		list.addAll(al);
		assertTrue(list.containsAll(al));
	}
	
	@Test
	public void shouldNotContainsInList() {
		assertFalse(list.contains(7));
	}
	
	@Test
	public void shouldContainsAll() {
		list.add(1); list.add(2); list.add(3); list.add(4);
		ArrayList<Integer> al = new ArrayList<>();
		al.add(2); al.add(3);
		
		assertTrue(list.containsAll(al));
	}
	
	@Test
	public void shouldGetObjectFromList() {
		list.add(1);
		list.add(2);
		list.add(3);
		
		int element = list.get(2);
		
		assertEquals(3, element);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldThrowArrayIndexOutOfBoundsException() {
		list.add(1);
		list.get(2);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldThrowArrayIndexOutOfBoundsExceptionIfIndexIsLowerThanZero() {
		list.add(1);
		list.get(-1);
	}
	
	@Test
	public void shouldGetIndexOfElement() {
		list.add(1);
		list.add(2);
		list.add(3);
		
		int index = list.indexOf(2);
		
		assertEquals(1, index);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArumentExepcion() {
		list.add(1);
		
		list.indexOf(5);
	}
	
	@Test
	public void shouldBeTrueIfArrayIsEmpty() {
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void shouldBeFalseIfArrayIsNotEmpty() {
		list.add(1);
		
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void shouldGetLastIndexOfElement() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(3);
		list.add(5);
		
		int index = list.lastIndexOf(3);
		
		assertEquals(4, index);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentException() {
		list.add(1);
		list.lastIndexOf(3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionIfArrayIsEmpty() {
		list.lastIndexOf(3);
	}
	
	@Test
	public void shouldClearArray() {
		list.add(1);
		list.add(2);
		list.add(3);
		
		list.clear();
		
		int size = list.size();
		
		assertEquals(0, size);
	}
	
	@Test
	public void shouldRemoveElement() {
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		
		list.add(a); list.add(b); list.add(c);
		list.remove(b);
		
		assertFalse(list.contains(b));
	}
	
	@Test
	public void shouldBeSublist() {
		list.add(1); list.add(2); list.add(3); list.add(4);
		List<Integer> temp = list.subList(1, 2);
		List<Integer> shouldBe = new ArrayList<>();
		shouldBe.add(2); shouldBe.add(3);
		assertTrue(temp.containsAll(shouldBe));
		
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldThrowArrayIndexOutOfBoundsExceptionForLeftBoundOfSublist() {
		list.add(1); list.add(2); list.add(3); list.add(4);
		list.subList(-1, 2);
		
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldThrowArrayIndexOutOfBoundsExceptionForRightBoundOfSublist() {
		list.add(1); list.add(2); list.add(3); list.add(4);
		list.subList(0, 8);
		
	}
	
	@Test
	public void shouldSetElementOnIndex() {
		list.add(1); list.add(2); list.add(3); list.add(4);
		Integer expect = 6;
		list.set(2, expect);
		assertEquals(expect, list.get(2));
	}
	
	@Test
	public void shouldReturnFalseContainsAll() {
		ArrayList<Integer> c = new ArrayList<>();
		c.add(1); c.add(3);
		list.add(2); list.add(4);
		assertFalse(list.containsAll(c));
	}
	
	@Test
	public void shouldReturnTrueForIteratorHasNext() {
		list.add(1); list.add(2);
		assertTrue(list.iterator().hasNext());
	}
	
	
}
