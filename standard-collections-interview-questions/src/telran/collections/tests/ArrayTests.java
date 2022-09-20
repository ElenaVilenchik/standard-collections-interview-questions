package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class ArrayTests {

	@Test
	void halfSum() {
		
		int arWithHalfSum[] = { 40, -20, 50, 10, 20 }; // sum=100, 40+10=50
		int ArWithHalfSum1[] = { -1, 1 };  // sum=0, -1+1=0
		int ArWithNoHalfSum[] = { 40, -20, 50, 5, 25 }; // sum=100, no two numbers with sum=50
		int ArWithNoHalfSum2[] = { 40, -20, 50, 4, 25 }; // sum odd number
		int ArWithNoHalfSum3[] = {};
		int ArWithNoHalfSum4[] = { 1 };

		assertTrue(isHalfSumTwoNumbers(arWithHalfSum));
		assertTrue(isHalfSumTwoNumbers(ArWithHalfSum1));
		assertFalse(isHalfSumTwoNumbers(ArWithNoHalfSum));
		assertFalse(isHalfSumTwoNumbers(ArWithNoHalfSum2));
		assertFalse(isHalfSumTwoNumbers(ArWithNoHalfSum4));
	}

	/**
	 * 
	 * @param array with no limitation
	 * @return true if there are two numbers with sum equaled half of total sum of a
	 *         given array
	 */
	
	private boolean isHalfSumTwoNumbers(int[] array) {
		
		boolean isHalfSum = true;
		
		if (array.length == 0) {
			throw new NoSuchElementException();
		}
		int arraySum = Arrays.stream(array).sum();

		if (arraySum % 2 != 0) {
			return !isHalfSum;
		}
		int halfArraySum = arraySum / 2;

		TreeSet<Integer> tree = Arrays.stream(array).boxed().collect(Collectors.toCollection(TreeSet::new));

		while (tree.size() >= 2) {

			int sumTwoNumbers = tree.first() + tree.last();

			int temp = sumTwoNumbers - halfArraySum;
			
			if (temp < 0) {
				tree.pollFirst();
			} else {
				if (temp > 0) {
					tree.pollLast();
				} else
					return isHalfSum;
			}
		}
		return !isHalfSum;
	}
	

	/**
	 * 
	 * @param array with numbers that may have the big values
	 * @return maximal value with existing negative image (negative value with same
	 *         absolute value) if no value with its negative image the function
	 *         returns -1
	 */	
	
	@Test
	void valueWithMaxNegativeTest() {
		
		int arWithNegative[] = { 10, 2, 20000, 4, 40, -4, 10, -2, -20000 };
		int arWithNoNegative[] = { 10, 20, 2, 4, 40, -14, 10, -21, -3 };
		assertEquals(20000, valueWithMaxNegative(arWithNegative));
		assertEquals(-1, valueWithMaxNegative(arWithNoNegative));
	}
	
	private Integer valueWithMaxNegative(int[] array) {
		
		Set<Integer> set = Arrays.stream(array)
				.boxed()
				.collect(Collectors.toCollection(HashSet::new));
		
		return set.stream()
				.filter(x -> set.contains(-x))
				.max(Integer::compare)
				.orElse(-1);
	}
}
