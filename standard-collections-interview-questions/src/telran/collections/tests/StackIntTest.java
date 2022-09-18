package telran.collections.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import telran.util.StackInt;

public class StackIntTest {

	public StackInt<Integer> stack;
	Integer[] number = { 0, 1, 2, 3, 4, -5 };

	@Before
	public void setup() {
		stack = new StackInt<>();
	}

	@Test
	public void testIsEmpty() throws Exception {
		assertEquals(true, stack.isEmpty());
		stack.push(5);
		assertEquals(false, stack.isEmpty());
		stack.pop();
		assertEquals(true, stack.isEmpty());
	}

	@Test
	public void testPush() throws Exception {
		for (int i = 0; i < number.length; i++) {
			stack.push(number[i]);
			assertEquals(number[i], stack.pop());
		}
	}

	@Test
	public void testPop() throws Exception {
		for (int i = 0; i < number.length; i++) {
			stack.push(number[i]);
		}
		for (int ii = number.length - 1; ii >= 0; ii--) {
			assertEquals(number[ii], stack.pop());
		}
		assertEquals(true, stack.isEmpty());
		assertThrows(NoSuchElementException.class, () -> stack.pop());
	}

	@Test
	public void testGetMaxNumber() throws Exception {
		for (int i = 0; i < number.length; i++) {
			stack.push(number[i]);
		}
		assertEquals(4, stack.getMaxNumber());
		stack.pop();
		stack.pop();
		assertEquals(3, stack.getMaxNumber());
	}

	@Test
	public void testGetMaxNumberFromTheEmptyStack() {
		assertThrows(NoSuchElementException.class, () -> stack.getMaxNumber());
	}
}
