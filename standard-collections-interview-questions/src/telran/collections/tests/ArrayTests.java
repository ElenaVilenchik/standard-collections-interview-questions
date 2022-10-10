package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

 class ArrayTests {

	@Test
	void halfSum() {

		int arWithHalfSum[] = { 40, -20, 50, 10, 20 }; // sum=100, 40+10=50
		int ArWithHalfSum1[] = { -1, 1 }; // sum=0, -1+1=0
		int ArWithNoHalfSum[] = { 40, -20, 50, 5, 25 }; // sum=100, no two numbers with sum=50
		int ArWithNoHalfSum2[] = { 40, -20, 50, 4, 25 }; // sum odd number
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
		int halfSum = Arrays.stream(array).sum() / 2;
		HashSet<Integer> setHelper = new HashSet<>();
		for (int num : array) {
			if (setHelper.contains(halfSum - num)) {
				return true;
			}
			setHelper.add(num);
		}
		return false;
	}
	
//my version O[n*log(n)}
//	private boolean isHalfSumTwoNumbers(int[] array) {
//
//		boolean isHalfSum = true;
//
//		if (array.length == 0) {
//			throw new NoSuchElementException();
//		}
//		int arraySum = Arrays.stream(array).sum();
//
//		if (arraySum % 2 != 0) {
//			return !isHalfSum;
//		}
//		int halfArraySum = arraySum / 2;
//
//		TreeSet<Integer> tree = Arrays.stream(array).boxed().collect(Collectors.toCollection(TreeSet::new));
//		
//		while (tree.size() >= 2) {
//
//			int sumTwoNumbers = tree.first() + tree.last();
//
//			int temp = sumTwoNumbers - halfArraySum;
//
//			if (temp < 0) {
//				tree.pollFirst();
//			} else {
//				if (temp > 0) {
//					tree.pollLast();
//				} else
//					return isHalfSum;
//			}
//		}
//		return !isHalfSum;
//	}

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
		int res = -1;
		HashSet<Integer> setHelper = new HashSet<>();
		for (int num : array) {
			int absNum = Math.abs(num);
			if (setHelper.contains(-num) && absNum > res) {
				res = absNum;
			}
			setHelper.add(num);
		}
		return res;
	}
	
	//my version
//	private Integer valueWithMaxNegative(int[] array) {
//
//		Set<Integer> set = Arrays.stream(array)
//				.boxed()
//				.collect(Collectors.toCollection(HashSet::new));
//
//		return set.stream().filter(x -> set.contains(-x)).max(Integer::compare).orElse(-1);
//	}
	
	/**
	 * The method doesn't update a given array
	 * 
	 * @param <T>
	 * @param array 
	 * examples: 
	 * {1,2,3,10,-1,5,6} -> false 
	 * {1,2,3,5,6,10} -> false
	 * {1,3,2,4,3,10} -> false 
	 * {10,2,3,4,1} -> true 
	 * {1,2,4,3,5,10} -> true
	 * {1,5,3,4,2,10} -> true  
	 *  {"lmn", "ab", "bc", "cd","a"} -> true
	 *  An Array should contain Comparable elements
	 * @return true if there is exactly one swap for getting sorted array
	 */
	@Test
	void isOneSwapTest() {
		Integer ar1[] = { 1, 2, 3, 10, -1, 5, 6 };
		Integer ar2[] = { 1, 2, 3, 5, 6, 10 };
		Integer ar3[] = { 1, 5, 2, 4, 3, 10 };
		Integer ar4[] = { 1, 3, 2, 5, 4, 10, 8 };
		Integer ar5[] = { 10, 2, 3, 4, 1 };
		Integer ar6[] = { 1, 2, 4, 3, 5, 10 };
		Integer ar7[] = { 1, 5, 3, 4, 2, 10 };
		String ar8[] = { "lmn", "ab", "bc", "cd", "a" };

		assertFalse(isOneSwapForSorted(ar1));
		assertFalse(isOneSwapForSorted(ar2));
		assertFalse(isOneSwapForSorted(ar3));
		assertFalse(isOneSwapForSorted(ar4));
		assertTrue(isOneSwapForSorted(ar5));
		assertTrue(isOneSwapForSorted(ar6));
		assertTrue(isOneSwapForSorted(ar7));
		assertTrue(isOneSwapForSorted(ar8));
	}

	@SuppressWarnings("unchecked")
	<T> boolean isOneSwapForSorted(T[] array) {
		int count = 0, first = 0, second = 0;

		for (int i = 1; i < array.length; i++) {
			if (((Comparable<T>) array[i]).compareTo(array[i - 1]) < 0) {
				count++;
				if (count > 2) {
					return false;
				}
				if (first == 0) {
					first = i;
				} else {
					second = i;
				}
			}
		}
		return count == 0 ? false : checkCount(array, count, first, second);
	}

	private <T> boolean checkCount(T[] array, int count, int first, int second) {

		return count == 1 ? finalArrayCheck(array, first - 2, first) : finalArrayCheck(array, second, first);
	}

	@SuppressWarnings("unchecked")
	private <T> boolean finalArrayCheck(T[] array, int index1, int index2) {

		return ((Comparable<T>) array[index1]).compareTo(array[index2]) < 0 ? true : false;
	}

}
