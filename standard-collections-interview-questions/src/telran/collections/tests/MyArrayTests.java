package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.MyArray;

class MyArrayTests {
	final int length = 5;

	MyArray<Integer> intArray = new MyArray<>(length);

	@BeforeEach
	void setUp() throws Exception {
		for (int i = 0; i < length; i++) {
			intArray.set(i, i + 1);
		}
	}

	@Test
	void getTest() {
		assertEquals(5, intArray.get(4));
		assertEquals(null, intArray.get(-4));
		assertEquals(null, intArray.get(14));
	}

	@Test
	void setTest() {
		assertThrows(IndexOutOfBoundsException.class, () -> intArray.set(10, 4));
		assertThrows(IndexOutOfBoundsException.class, () -> intArray.set(-10, 4));
	}

	@Test
	void setAllTest() {
		intArray.setAll(100);
		assertEquals(100, intArray.get(3));
		intArray.setAll(0);
		assertEquals(0, intArray.get(2));
		intArray.set(1, 10);
		assertEquals(10, intArray.get(1));
	}
}
