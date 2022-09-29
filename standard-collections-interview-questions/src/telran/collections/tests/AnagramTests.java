package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.util.Anagram;

class AnagramTests {
//	@Test
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

	
	//tests Granivsky	
	String word = "yellow";
	@Test
	void testAnagramTrue() {
		assertTrue(Anagram.isAnagram(word, "loweyl"));
		assertTrue(Anagram.isAnagram(word, "elolyw"));
		assertTrue(Anagram.isAnagram(word, "wolley"));
		assertTrue(Anagram.isAnagram(word, "loleyw"));
		
	}
	@Test
	void testAnagramFalse() {
		assertFalse(Anagram.isAnagram(word,""));
		assertFalse(Anagram.isAnagram(word, "yellob"));
		assertFalse(Anagram.isAnagram(word,"yello"));
		assertFalse(Anagram.isAnagram(word,"yelllo"));
	
	}
	
	
}



