package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.util.Anagram;

class AnagramTests {
	@Test
	void testIsAnagram() {
		String str1 = "Hello";
		String str2 = "Helll";
		String str3 = "eloHl";
		String str4 = "Hel";
		String str5 = "Abcdf";
		assertTrue(Anagram.isAnagram(str1, str1));
		assertTrue(Anagram.isAnagram(str1, str3));
		assertFalse(Anagram.isAnagram(str1, str2));
		assertFalse(Anagram.isAnagram(str1, str4));
		assertFalse(Anagram.isAnagram(str1, str5));
	}
}
