package suggester;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.Util;
import util.WordLists;

public class Suggester {

	private static final char WILDCARD = '?';

	public Trie trie;

	/**
	 * @param words
	 */
	public Suggester(Collection<String> words) {
		trie = new Trie(words);
	}

	/**
	 * @param str
	 * @return
	 */
	private static int maxEditDistance(String str) {
		if (str.length() <= 4) {
			return 1;
		}
		if (str.length() <= 12) {
			return 2;
		}
		return 3;
	}

	/**
	 * @param editsLeft
	 * @param str
	 * @param idx
	 * @param set
	 */
	public void addWildcards(int editsLeft, String str, int idx, Set<String> set) {
		if (idx > str.length() || editsLeft == 0) {
			set.add(str);
			return;
		}
		StringBuilder sb = null;

		// don't edit
		addWildcards(editsLeft, str, idx + 1, set);

		// insert
		sb = new StringBuilder(str);
		addWildcards(editsLeft - 1, sb.insert(idx, WILDCARD).toString(), idx + 1, set);

		if (idx != str.length()) {

			// delete
			sb = new StringBuilder(str);
			addWildcards(editsLeft - 1, sb.deleteCharAt(idx).toString(), idx + 1, set);

			// change
			sb = new StringBuilder(str);
			sb.setCharAt(idx, WILDCARD);
			addWildcards(editsLeft - 1, sb.toString(), idx + 1, set);

			// transpose
			char[] arr = str.toCharArray();
			if (idx != str.length() - 1) {
				Util.swap(arr, idx, idx + 1);
			}
			addWildcards(editsLeft - 1, new String(arr), idx + 2, set);
		}

	}

	/**
	 * @param str
	 * @param ed
	 * @return
	 */
	public Set<String> getCandidates(String str, int ed) {
		Set<String> candidates = new HashSet<>();
		addWildcards(ed, str, 0, candidates);
		return candidates;
	}

	/**
	 * @param str
	 * @return
	 */
	public List<String> suggestions(String str) {
		List<String> suggestions = new ArrayList<>();

		for (String s : getCandidates(str, maxEditDistance(str))) {
			suggestions.addAll(trie.wildcardMatches(s));
		}

		suggestions = new ArrayList<>(new HashSet<>(suggestions));

		Collections.sort(suggestions, new ProximityComparator(str));

		if (suggestions.size() >= 5) {
			return suggestions.subList(0, 5);
		}
		return suggestions;
	}

	/**
	 * @param str
	 * @return
	 */
	public List<String> autocomplete(String str) {
		List<String> suggestions = trie.prefixedWords(str);

		Collections.sort(suggestions, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				Integer freq1 = WordLists.freqMap.get(arg0);
				Integer freq2 = WordLists.freqMap.get(arg1);
				if (freq1 == null && freq2 == null) {
					return 0;
				} else if (freq1 == null) {
					return 1;
				} else if (freq2 == null) {
					return -1;
				}
				return freq2 - freq1;
			}

		});

		if (suggestions.size() >= 5) {
			return suggestions.subList(0, 5);
		}
		return suggestions;
	}

}
