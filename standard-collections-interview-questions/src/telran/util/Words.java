package telran.util;
import java.util.*;
///**
//* adds word
//* 
//* @param word
//* @return true if added, otherwise false if an word already exists (case
//*         insensitive)
//*/
public class Words {
	TreeSet<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	/**
	 * adds word
	 * @param word
	 * @return true if added, otherwise false if an word already exists (case insensitive)
	 */
	public boolean addWord(String word) {
		
		return set.add(word);
	}
	/**
	 * 
	 * @param prefix
	 * @return list of words starting from a given prefix (case insensitive)
	 */
	public List<String> getWordsByPrefix(String prefix) {
		
		return new ArrayList<>(set.subSet(prefix, getPrefixLimit(prefix)));
	}
	private String getPrefixLimit(String prefix) {
		char lastChar = prefix.charAt(prefix.length() - 1);
		char limitChar = (char) (lastChar + 1);
		return prefix.substring(0, prefix.length() - 1) + limitChar;

	}
}

//my versions

//package telran.util;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.TreeSet;
//
//public class Words {
//	TreeSet<String> tree = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
//

//	public boolean addWord(String word) {
//
//		return tree.add(word);
//	}
//
//	/**
//	 * 
//	 * @param prefix
//	 * @return list of words starting from false if an word already exists (case
//	 *         insensitive)
//	 */
//	public List<String> getWordsByPrefix(String prefix) {
//
//		char charLast = prefix.charAt(prefix.length() - 1);
//
//		String postfix = prefix.substring(0, prefix.length() - 1) + (char) (charLast + 1);
//
//		return new ArrayList<String>(tree.subSet(prefix, true, postfix, false));
//	}
//
//}
