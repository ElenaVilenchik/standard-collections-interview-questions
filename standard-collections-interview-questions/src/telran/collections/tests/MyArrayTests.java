package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.MyArray;

class MyArrayTests {
	
	//Granovsky
	private static final int LENGTH = 1000;
	private static final int VALUE = 10;
	private static final int OTHER_VALUE = 5;
	MyArray<Integer> array;

	@BeforeEach
	void setUp() throws Exception {
		array = new MyArray<>(LENGTH);
		array.setAll(VALUE);
	}

	@Test
	void testSetAll() {
		for (int i = 0; i < LENGTH; i++) {
			assertEquals(VALUE, array.get(i));
		}
	}

	@Test
	void testSetGet() {
		array.set(0, OTHER_VALUE);
		array.set(LENGTH - 1, OTHER_VALUE);
		int limit = LENGTH - 1;
		for (int i = 1; i < limit; i++) {
			assertEquals(VALUE, array.get(i));
		}
		assertEquals(OTHER_VALUE, array.get(0));
		assertEquals(OTHER_VALUE, array.get(limit));
		array.setAll(OTHER_VALUE);
		for (int i = 0; i < LENGTH; i++) {
			assertEquals(OTHER_VALUE, array.get(i));
		}
	}
	
//	final int length = 5;
//
//	MyArray<Integer> intArray = new MyArray<>(length);
//
//	@BeforeEach
//	void setUp() throws Exception {
////		for (int i = 0; i < length; i++) {
////			intArray.set(i, i + 1);
////		}
//		intArray.setAll(1);
//	}
//
//	@Test
//	void getTest() {
//		assertEquals(1, intArray.get(0));
//		assertEquals(null, intArray.get(-4));
//		assertEquals(null, intArray.get(14));
//	}
//
//	@Test
//	void setTest() {
//		intArray.set(1, 10);
//		assertEquals(10, intArray.get(1));
//		assertThrows(IndexOutOfBoundsException.class, () -> intArray.set(10, 4));
//		assertThrows(IndexOutOfBoundsException.class, () -> intArray.set(-10, 4));
//	}
//
//	@Test
//	void setAllTest() {
//		intArray.set(3, 7);
//		assertEquals(7, intArray.get(3));
//		intArray.setAll(0);
//		assertEquals(0, intArray.get(2));
//		intArray.set(2, 10);
//		assertEquals(10, intArray.get(2));
//	}
}
