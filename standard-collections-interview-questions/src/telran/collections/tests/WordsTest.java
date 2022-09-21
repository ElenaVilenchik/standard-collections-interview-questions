package telran.collections.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordsTest {
	String[] words = { "a", "ab", "f", "abc", "b", "azxc", "fav", "fav9", "fa" };
	TreeSet<String> tree;

	@BeforeEach
	void setUp() throws Exception {
		tree = new TreeSet<>(Arrays.asList(words));

	}

	@Test
	void testAddWord() {
		tree.add("AzX".toLowerCase());
		assertTrue(tree.contains("azx"));
	}

	@Test
	void testGetWordsByPrefix() {
		String[] expectedA = { "ab", "abc" };
		assertArrayEquals(expectedA, getWordsByPrefix("aB").toArray(String[]::new));
		String[] expectedF = { "f", "fa", "fav", "fav9" };
		assertArrayEquals(expectedF, getWordsByPrefix("F").toArray(String[]::new));
	}

	boolean addWord(String word) {
		return tree.add(word.toLowerCase());
	}

	 List<String> getWordsByPrefix(String prefix) {

		prefix = prefix.toLowerCase();

		char charLast = prefix.charAt(prefix.length() - 1);

		String postfix = prefix.replace(charLast, (char) (charLast + 1));

		return new ArrayList<String>(tree.subSet(prefix, true, postfix, false));
	}

}
