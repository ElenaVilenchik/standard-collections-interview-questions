package telran.collections.tests;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Words;

class WordsTest {

	String words[] = { "abcdef", "ab123", "aaa", "ab", "ablmn", "abbbb", "a", "ABd", "bbb", "B12", "*/" };
	String wordsStartB[] = { "B12", "bbb" };
	String wordsStartAB[] = { "ab", "ab123", "abbbb", "abcdef", "ABd", "ablmn" };
	String wordsStartABC[] = { "abcdef" };
	String wordsStartAsteric[] = { "*/" };
	Words elasticSearch;

	@BeforeEach
	void setUp() throws Exception {
		elasticSearch = new Words();
		for (String word : words) {
			elasticSearch.addWord(word);
		}
	}

	@Test
	void test() {
		assertArrayEquals(wordsStartABC, elasticSearch.getWordsByPrefix("abc").toArray(String[]::new));
		assertArrayEquals(wordsStartB, elasticSearch.getWordsByPrefix("B").toArray(String[]::new));
		assertArrayEquals(wordsStartAB, elasticSearch.getWordsByPrefix("ab").toArray(String[]::new));
		assertArrayEquals(wordsStartAsteric, elasticSearch.getWordsByPrefix("*").toArray(String[]::new));
	}
}

//my version
//package telran.collections.tests;
//
//import static org.junit.Assert.assertArrayEquals;
//import static org.junit.Assert.assertTrue;
//
//import java.util.Arrays;
//import java.util.TreeSet;
//import telran.util.Words;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class WordsTest {
//	String[] words = { "a", "aB", "F", "abc", "b", "azxc", "fav", "fav9", "fa","}" };
//	TreeSet<String> tree;
//
//	@BeforeEach
//	void setUp() throws Exception {
//		tree = new TreeSet<>(Arrays.asList(words));
//
//	}
//
//	@Test
//	void testAddWord() {
//		addWord("AzX");
//		assertTrue(tree.contains("AzX"));
//	}
//
//	@Test
//	void testGetWordsByPrefix() {
//		String[] expectedA = { "aB", "abc" };
//		assertArrayEquals(expectedA, getWordsByPrefix("aB").toArray(String[]::new));
//		String[] expectedF = { "F", "fa", "fav", "fav9" };
//		assertArrayEquals(expectedF, getWordsByPrefix("F").toArray(String[]::new));
//		String[] expectedAa = { "}"  };
//		assertArrayEquals(expectedAa, getWordsByPrefix("}" ).toArray(String[]::new));
//	}
//}
