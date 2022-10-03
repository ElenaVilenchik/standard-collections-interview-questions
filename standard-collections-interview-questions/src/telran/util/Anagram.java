package telran.util;

import java.util.HashMap;

public class Anagram {
	/**
	 * 
	 * @param word
	 * @param anagram
	 * @return
	 * @return true if anagram is one of the possible anagrams of a given word
	 *         anagram is a string containing all symbols from a fiven word with
	 *         different order Example: yellow (wolely, lowlye, yellow), wrong
	 *         anagrams (yello, yelllw)
	 */

	public static boolean isAnagram(String word, String anagram) {

		if (word.length() != anagram.length()) {
			return false;
		}
		HashMap<Character, Integer> mapLetters = new HashMap<>();

		word.chars().forEach(letter -> mapLetters.merge((char) letter, 1, Integer::sum));

		anagram.chars().forEach(letter -> {
			Integer count = mapLetters.computeIfPresent((char) letter, (k, v) -> --v);
			if (count == null || count < 0) {
				mapLetters.clear();
				return;
			}
		});
		return !mapLetters.isEmpty();
	}

	// Granovsky
//	public static boolean isAnagram(String word, String anagram) {
//		boolean res = false;
//		if (word.length() == anagram.length()) {
//			HashMap<Character, Integer> mapLetters = getMapLetters(word);
//			res = true;
//			for (char letter : anagram.toCharArray()) {
//				Integer count = mapLetters.getOrDefault(letter, 0);
//				if (count == 0) {
//					res = false;
//					break;
//				}
//				mapLetters.put(letter, count - 1);
//			}
//		}
//		return res;
//	}
//
//	private static HashMap<Character, Integer> getMapLetters(String word) {
//		HashMap<Character, Integer> res = new HashMap<>();
//		for (char letter : word.toCharArray()) {
//			Integer count = res.getOrDefault(letter, 0);
//			res.put(letter, count + 1);
//		}
//		return res;
//	}	

//	public static boolean isAnagram(String word, String anagram) {
//
//		return (word.length() == anagram.length() && itReallyAnagram(word, anagram));
//	}
//
//	private static boolean itReallyAnagram(String word, String anagram) {
//		HashMap<Character, Integer> map = getMap(word);
//		for (int i = 0; i < anagram.length(); i++) {
//			if (map.containsKey(anagram.charAt(i)) && (map.get(anagram.charAt(i)) > 0)) {
//				map.put(anagram.charAt(i), map.get(anagram.charAt(i)) - 1);
//			} else {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	private static HashMap<Character, Integer> getMap(String word) {
//		HashMap<Character, Integer> res = new HashMap<>();
//		for (int i = 0; i < word.length(); i++) {
//			Integer count = res.getOrDefault(word.charAt(i), 0);
//			res.put(word.charAt(i), count + 1);
//		}
//		return res;
//	}

}