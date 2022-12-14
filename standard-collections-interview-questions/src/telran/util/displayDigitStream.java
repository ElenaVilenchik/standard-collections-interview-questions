package telran.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class displayDigitStream {
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = Integer.MAX_VALUE;
	private static final long N_RUNS = 10_000_000;

	public static void main(String[] args) {
		displayDigitStatistics();
		displayDigitStatisticsFastest();
		displayDigitStatisticsSuperFastest();
		displayDigitStatisticsSuperFastestMy();
		displayDigitStatisticsSuperFastestGR();
	}

	private static void displayDigitStatistics() {
		long start = System.currentTimeMillis();

		new Random().ints(N_RUNS, MIN_VALUE, MAX_VALUE).flatMap(x -> Integer.toString(x).chars()).parallel().boxed()
				.collect(Collectors.groupingBy(Function.identity(), // x->x
						Collectors.counting()))

				.entrySet().stream().sorted(
						// (e1, e2) -> Long.compare(e2.getValue(), e1.getValue())
						Map.Entry.<Integer, Long>comparingByValue().reversed())
				.forEach(x -> System.out.printf("%c -> %d\n", x.getKey(), x.getValue()));

		System.out.println(System.currentTimeMillis() - start);
	}

	
	private static void displayDigitStatisticsFastest() {
		long start = System.currentTimeMillis();

		long[] digCounters = new Random().ints(N_RUNS, MIN_VALUE, MAX_VALUE).flatMap(x -> Integer.toString(x).chars())
				.parallel().collect(() -> new long[10], (arr, i) -> arr[i - '0']++, (arr1, arr2) -> {
					for (int i = 0; i < 10; i++) {
						arr1[i] += arr2[i];
					}
				});

		Map<Integer, Long> map = new HashMap<>(10);
		for (int i = 0; i < 10; i++) {
			map.put(i, digCounters[i]);
		}
		map.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
				.forEach(x -> System.out.printf("%d -> %d\n", x.getKey(), x.getValue()));

		System.out.println(System.currentTimeMillis() - start);
	}

	
	// By Maria Disin - sequential array instead of parallel stream
	private static void displayDigitStatisticsSuperFastest() {
		long start = System.currentTimeMillis();

		long[] digitCounts = new long[10];
		new Random().ints(N_RUNS, MIN_VALUE, MAX_VALUE)
				// .parallel() // ERROR!
				.forEach(num -> {
					while (num > 0) {
						int digit = num % 10;
						++digitCounts[digit];
						num /= 10;
					}
				});

		Map<Integer, Long> map = new HashMap<>(10);
		for (int i = 0; i < 10; i++) {
			map.put(i, digitCounts[i]);
		}
		map.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
				.forEach(x -> System.out.printf("%d -> %d\n", x.getKey(), x.getValue()));

		System.out.println(System.currentTimeMillis() - start);
	}

	// my - sequential array instead of parallel stream
	private static void displayDigitStatisticsSuperFastestMy() {
		long[] digitCounts = new long[10];
		long start = System.currentTimeMillis();

		new Random().ints(N_RUNS, MIN_VALUE, MAX_VALUE).forEach(num -> {
			while (num > 0) {
				int digit = num % 10;
				++digitCounts[digit];
				num /= 10;
			}
		});
		HashMap<Integer, Long> mapDigits = new HashMap<>(10);
		for (int i = 0; i < 10; i++) {
			mapDigits.put(i, digitCounts[i]);
		}
		// IntStream.range(0, 10).forEach(i -> mapDigits.put(i, digitCounts[i]));

		mapDigits.entrySet().stream()
		.sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
				// .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
				.forEach(x -> System.out.printf("%d : %d\n", x.getKey(), x.getValue()));
		
		System.out.println(System.currentTimeMillis() - start);
	}
	
	//granovsky
	private static void displayDigitStatisticsSuperFastestGR() {
		long start = System.currentTimeMillis();
		new Random().ints(N_RUNS, MIN_VALUE, MAX_VALUE)
		.mapToObj(Integer::toString).flatMapToInt(String::chars)
		.boxed()//.mapToObj(n->n)
		.collect(Collectors.groupingBy(n->n,Collectors.counting()))
		.entrySet().stream().sorted((e1,e2)->Long.compare(e2.getValue(), e1.getValue()))
		.forEach(e->System.out.printf("%c : %d\n", e.getKey(), e.getValue()));
		
		System.out.println(System.currentTimeMillis() - start);
	}
	
}
