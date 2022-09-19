//Granovsky
package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.util.StackInt;

class StackIntTest {
	private static final long N_NUMBERS = 10000;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 100;
	StackInt stack = new StackInt();
	LinkedList<Integer> list = new LinkedList<>();
	StackInt stackEmpty = new StackInt();
	Random gen = new Random();

	@BeforeEach
	void setUp() throws Exception {
		gen.ints(N_NUMBERS, MIN_NUMBER, MAX_NUMBER).forEach(n -> {
			stack.push(n);
			list.add(n);
		});
	}

	@Test
	void testPop() {
		assertEquals(list.removeLast(), stack.pop());
		assertThrows(NoSuchElementException.class, () -> stackEmpty.pop());
	}

	@Test
	void testPush() {
		stack.push(10);
		assertNotEquals(list.removeLast(), stack.pop());
	}

	@Test
	void testIsEmpty() {
		assertFalse(stack.isEmpty());
		assertTrue(stackEmpty.isEmpty());
	}

	@Test
	void testGetMaxNumber()  {
		testRandom();
		predefinedMaxTest();
	}

	void testRandom() {
		for (int i = 0; i < N_NUMBERS; i++) {
			if (Math.random() * 100 < 50) {
				try {
					stack.pop();
					list.removeLast();
				} catch (Exception e) {
				}
			} else {
				int number = gen.nextInt(MIN_NUMBER, MAX_NUMBER);
				stack.push(number);
				list.add(number);
			}
		}
		assertEquals((int) Collections.max(list), stack.getMaxNumber());
	}

	void predefinedMaxTest() {
		int ar[] = { 100000, 50000, 100000, 20, 20, 20, 2000000 };
		for (int i = 0; i < ar.length; i++) {
			stack.push(ar[i]);
		}
		assertEquals(2000000, stack.getMaxNumber());
		stack.pop();
		stack.pop();
		stack.pop();
		assertEquals(100000, stack.getMaxNumber());
	}
}

//my version better and speed

//package telran.collections.tests;
//import static org.junit.Assert.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.NoSuchElementException;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import telran.util.StackInt;
//
//public class StackIntTest {
//
//	public StackInt<Integer> stack;
//	Integer[] number = { 0, 1, 2, 3, 4, -5 };
//
//	@Before
//	public void setup() {
//		stack = new StackInt<>();
//	}
//
//	@Test
//	public void testIsEmpty() throws Exception {
//		assertEquals(true, stack.isEmpty());
//		stack.push(5);
//		assertEquals(false, stack.isEmpty());
//		stack.pop();
//		assertEquals(true, stack.isEmpty());
//	}
//
//	@Test
//	public void testPush() throws Exception {
//		for (int i = 0; i < number.length; i++) {
//			stack.push(number[i]);
//			assertEquals(number[i], stack.pop());
//		}
//	}
//
//	@Test
//	public void testPop() throws Exception {
//		for (int i = 0; i < number.length; i++) {
//			stack.push(number[i]);
//		}
//		for (int ii = number.length - 1; ii >= 0; ii--) {
//			assertEquals(number[ii], stack.pop());
//		}
//		assertEquals(true, stack.isEmpty());
//		assertThrows(NoSuchElementException.class, () -> stack.pop());
//	}
//
//	@Test
//	public void testGetMaxNumber() throws Exception {
//		assertThrows(NoSuchElementException.class, () -> stack.getMaxNumber());
//		for (int i = 0; i < number.length; i++) {
//			stack.push(number[i]);
//		}
//		assertEquals(4, stack.getMaxNumber());
//		stack.pop();
//		stack.pop();
//		assertEquals(3, stack.getMaxNumber());
//	}
//
//}
