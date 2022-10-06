package telran.structure;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultiCountersTest {

	MultiCountersImpl counter = new MultiCountersImpl();
	MultiCountersImpl counterFull = new MultiCountersImpl();
	String strings[] = { "a", "aa", "aaa", "a", "aaa", "aaa", "b", "ab", "x", "x", "x" };

	@BeforeEach
	void setUp() {
		for (String string : strings) {
			counter.addItem(string);
		}
	}

	@Test
	void addItem() {
		assertEquals(3, counter.addItem("a"));
		assertEquals(1, counter.addItem("c"));
	}

	@Test
	void getValue() {
		assertEquals(2, counter.getValue("a"));
		assertEquals(0, counter.getValue("d"));
	}

	@Test
	void remove() {
		int value = counter.getValue("aaa");
		for (int i = 0; i < value; i++) {
			assertTrue(counter.remove("aaa"));
		}
		assertFalse(counter.remove("aaa"));

		assertTrue(counter.remove("b"));
		assertFalse(counter.remove("b"));

		assertFalse(counter.remove("d"));
		assertFalse(counterFull.remove("aa"));
		
		Set<String> expected = Set.of( "x");
		assertEquals(expected, counter.getMaxItems());
	}

	@Test
	void getMaxItems() {
		Set<String> expected = Set.of("aaa", "x");
		assertEquals(expected, counter.getMaxItems());
		Set<String> expectedFull = Set.of("");
		// assertEquals(expectedFull, counterFull.getMaxItems());
	}
	
}