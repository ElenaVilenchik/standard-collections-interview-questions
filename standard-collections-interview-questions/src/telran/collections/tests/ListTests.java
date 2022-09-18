package telran.collections.tests;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListTests {
	Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	List<Integer> list = Arrays.asList(numbers);
	List<Integer> listMutable;

	@BeforeEach
	void setUp() {
		listMutable = new ArrayList<>(list);
	}

	@Test
	void listImmutableMutableTest() {
		assertThrows(UnsupportedOperationException.class, () -> list.remove(0));
		Integer[] expected = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		assertEquals(1, listMutable.remove(0));
		assertArrayEquals(expected, listMutable.toArray(new Integer[0]));
	}

	@Test
	void listViewTest() {
		List<Integer> subList = listMutable.subList(2, 10);
		Integer[] expected = { 3, 4, 5, 6, 7, 8, 9, 10 };
		assertArrayEquals(expected, subList.toArray(new Integer[0]));
		Integer[] expectedAfterRemove = { 1, 2, 3, 4, 5, 6, 8, 9, 10 };
		// subList.remove((Integer)7); equals to subList.remove(4);
		subList.remove(4);
		assertArrayEquals(expectedAfterRemove, listMutable.toArray(new Integer[0]));
		subList.add(4, 7);
		assertArrayEquals(numbers, listMutable.toArray(new Integer[0]));
		subList.clear();
		assertEquals(2, listMutable.size());
	}
	
	@Test
	void queueTest() {
		Stack<Integer> stack = new Stack<>();
		stack.add(1);
		System.out.println(stack);
		stack.add(2);
		System.out.println(stack);
		stack.add(3);
		System.out.println(stack);
		stack.add(1, 10);
		System.out.println(stack);
		stack.remove(1);
		System.out.println(stack);
		Queue<Integer> queue = new LinkedList<>(list);
		assertEquals(1, queue.remove());
		Integer[] expected = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		assertArrayEquals(expected, queue.toArray(new Integer[0]));
		Queue<Integer> queue1 = new LinkedList<>();
		assertThrows(NoSuchElementException.class, () -> queue1.remove());
		assertNull(queue1.poll());
		assertEquals(true, queue.remove(7));
		assertFalse(queue.contains(7));
		listMutable.remove(7);
		assertTrue(listMutable.contains(7));
	}
}
