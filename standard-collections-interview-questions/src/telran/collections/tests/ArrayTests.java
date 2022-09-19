package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Test;

class ArrayTests {

	@Test
	void halfSum() {
		int arWithHalfSum[] = { 40, -20, 50, 10, 20 }; // sum=100, 40+10=50
		int ArWithNoHalfSum[] = { 40, -20, 50, 5, 25 }; // sum=100, no two numbers with sum=50
		assertTrue(isHalfSumTwoNumbers(arWithHalfSum));
		assertFalse(isHalfSumTwoNumbers(ArWithNoHalfSum));
	}

	/**
	 * 
	 * @param array
	 * @return true if there are two numbers with sum equaled half of total sum of a
	 *         given array
	 */
	private BooleanSupplier isHalfSumTwoNumbers(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	void valueWithMaxNegativeTest() {
		int arWithNegative[] = { 10, 20, 2, 4, 40, -4, 10, -20, -2 };
		int arWithNoNegative[] = { 10, 20, 2, 4, 40, -14, 10, -21, -3 };
		assertEquals(20, valueWithMaxNegative(arWithNegative));
		assertEquals(-1, valueWithMaxNegative(arWithNoNegative));
	}

	/**
	 * 
	 * @param array
	 * @return maximal value with existing negative image (negative value with same
	 *         absolute value) if no value with its negative image the function
	 *         returns -1
	 */
	private Integer valueWithMaxNegative(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}
}
