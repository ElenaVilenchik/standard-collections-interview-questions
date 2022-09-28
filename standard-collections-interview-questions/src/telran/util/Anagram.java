package telran.util;

import java.util.HashMap;

public class Anagram {
	/**
	 * 
	 * @param word
	 * @param anagram
	 * @return true if anagram is one of the possible anagrams of a given word
	 *         anagram is a string containing all symbols from a fiven word with
	 *         different order Example: yellow (wolely, lowlye, yellow), wrong
	 *         anagrams (yello, yelllw)
	 */
	public static boolean isAnagram(String word, String anagram) {

		return (word.length() == anagram.length() && itReallyAnagram(word, anagram));
	}

	private static boolean itReallyAnagram(String word, String anagram) {
		HashMap<Character, Integer> map = getMap(word);
		for (int i = 0; i < anagram.length(); i++) {
			if (map.containsKey(anagram.charAt(i)) && (map.get(anagram.charAt(i)) > 0)) {
				map.put(anagram.charAt(i), map.get(anagram.charAt(i)) - 1);
			} else {
				return false;
			}
		}
		return true;
	}

	private static HashMap<Character, Integer> getMap(String word) {
		HashMap<Character, Integer> res = new HashMap<>();
		for (int i = 0; i < word.length(); i++) {
			Integer count = res.getOrDefault(word.charAt(i), 0);
			res.put(word.charAt(i), count + 1);
		}
		return res;
	}

}