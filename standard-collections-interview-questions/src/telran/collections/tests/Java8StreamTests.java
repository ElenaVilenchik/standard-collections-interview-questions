package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// one to one is map
// one to many  is flatMap
// mane to one is collect

class Java8StreamTests {
	static class Programmer {
		String name;
		int age;
		String[] technologies;

		public Programmer(String name, int age, String[] technologies) {
			this.name = name;
			this.age = age;
			this.technologies = technologies;
		}

		public int getAge() {
			return age;
		}

		public String[] getTechnolgies() {
			return technologies;
		}
	}

	List<Programmer> programmers;
	String[] technologies1 = { "Java", "SQL", "C++" };
	String[] technologies2 = { "Java" };
	String[] technologies3 = { "Java", "React", "SQL" };

	@BeforeEach
	void setUp() {
		programmers = Arrays.asList(new Programmer("Vasya", 30, technologies1),
				new Programmer("Petya", 25, technologies2), new Programmer("Sara", 35, technologies3));
	}

	@Test
	void averageProgrammersAgeTest() {
		assertEquals(30.0, getAverageAge());
	}

	private Double getAverageAge() {
		// return programmers.stream().mapToInt(p -> p.getAge()).average().orElse(0);
		return programmers.stream().collect(Collectors.averagingInt(Programmer::getAge));
	}

	@Test
	void mostPopularTechnologyTest() {
		assertEquals("Java", getMostPopularTechnology());
	}

	private Object getMostPopularTechnology() {
		for(String s:technologies1) {
			System.out.println(s);
		}
		return programmers.stream().flatMap(p -> Arrays.stream(p.getTechnolgies()))
				.collect(Collectors.groupingBy(t -> t, Collectors.counting())).entrySet().stream()
				.sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
				.map(Map.Entry<String, Long>::getKey)
				.findFirst().orElse(null);
	}

	@Test
	void testSumTwoDimArray() {
		int ar[][] = { { Integer.MAX_VALUE, 2 }, { 3, 4, 5 }, { 7 } };
		assertEquals(Integer.MAX_VALUE + 21L, sumTwoDimArray(ar));
	}

	private Long sumTwoDimArray(int[][] ar) {
		return Arrays.stream(ar).flatMapToInt(a -> Arrays.stream(a)).asLongStream().sum();
	}

	@Test
	void printDigitOccurences() {

//	generate 1_000_000 random numbers from 0 to Integer.MAX_VALUE
		// print digits occurrence in descending order of occurrences
//	1: <occurrences>
//	2:...
//	...
		
		
//		int[] ar = IntStream.generate(() -> new Random().nextInt(Integer.MAX_VALUE)).limit(10).toArray();
//	
//		String joinedString = Arrays.toString(ar);
//		Map<Integer, Integer> res = new HashMap<>();
//		 Arrays.stream(joinedString.split(", "))
//			    .filter((s) -> s.matches("\\d+"))
//			    .collect(Collectors.groupingBy(t -> t, Collectors.counting())).entrySet().stream()
//				.sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())).filter(e -> e.getKey())
//		  .map(Map.Entry::getValue)
//				.forEach(System.out::println); 

		
		
//		String[] strToArray=Arrays.toString(ar)
//		IntStream intStream = joinedString.chars();
//		Stream<String> streamOfArray = Arrays.stream(strToArray);
//		
//		intStream.flatMap(p -> Arrays.stream(strToArray))
//			.collect(Collectors.groupingBy(t -> t, Collectors.counting())).entrySet().stream()
//				.sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())).filter(e -> e.getKey())
//		  .map(Map.Entry::getValue)
//				.forEach(System.out::println);
		
		
		int[] arr = IntStream.generate(() -> new Random().nextInt(Integer.MAX_VALUE)).limit(1_000_000).toArray();

		Map<Integer, Integer> res = new HashMap<>();
		for (int val : arr) {
			do {
				res.compute(val % 10, (k, v) -> v == null ? 1 : v + 1);
				val /= 10;
			} while (val > 0);
		}
		res.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
				.forEach(System.out::println);


//		IntStream.range(0, Integer.MAX_VALUE).flatMap(a->Arrays.stream())
//	.iterate(num, i -> i / 10 > 0 || i % 10 > 0, i -> i / 10)
//		.limit(1_000_000)
//    .map(i -> i % 10)
//   
//	collect(Collectors.groupingBy(t -> t, Collectors.counting())).entrySet().stream()
//	.sorted((e1, e2) ->Integer.compare(e2.getValue(), e1.getValue())
//	.forEach(System.out::println));	
	}
}
