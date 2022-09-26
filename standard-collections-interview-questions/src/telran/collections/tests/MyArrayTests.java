package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.MyArray;

class MyArrayTests {
	MyArray<Integer> elements;

	@BeforeEach
	void setUp() throws Exception {
		elements = new MyArray<Integer>(10);
		elements.setAll(0);
	}

	@Test
	void getTest() {
		assertEquals(0, elements.get(4));
		assertNotEquals(3, elements.get(0));
	}

	@Test
	void setTest() {
		elements.set(1, 5);
		assertEquals(5, elements.get(1));
		assertThrows(IndexOutOfBoundsException.class, () -> elements.set(10, 4));
	}
}
