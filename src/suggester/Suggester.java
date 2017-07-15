package suggester;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.Util;

public class Suggester {

	private static final char WILDCARD = '?';

	private Trie trie;

	public static final int MAX_EDIT_DISANCE_THRESHOLD = 3;

	public Suggester(Collection<String> words) {
		trie = new Trie(words);
	}

	private static int validateDistance(int ed) {
		return ed > MAX_EDIT_DISANCE_THRESHOLD ? MAX_EDIT_DISANCE_THRESHOLD : ed;
	}

	public void addWildcards(int editsLeft, String str, int idx, Set<String> set) {
		if (idx > str.length() || editsLeft == 0) {
			set.add(str);
			return;
		}
		StringBuilder sb = null;

		// don't edit
		addWildcards(editsLeft, str, idx + 1, set);

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
		// insert
		sb = new StringBuilder(str);
		addWildcards(editsLeft - 1, sb.insert(idx, WILDCARD).toString(), idx + 1, set);
	}

	public Set<String> getCandidates(String str, int ed) {
		Set<String> candidates = new HashSet<>();
		addWildcards(ed, str, 0, candidates);
		return candidates;
	}

	public List<String> suggestions(String str, int maxEditDist) {
		maxEditDist = validateDistance(maxEditDist);

		List<String> matches = new ArrayList<>();

		for (String s : getCandidates(str, maxEditDist)) {
			matches.addAll(trie.wildcardMatches(s));
		}

		matches = new ArrayList<>(new HashSet<>(matches));

		Collections.sort(matches, new DamerauLevenshteinDistanceComparator(str));

		return matches;
	}

}
