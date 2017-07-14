package suggester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.Util;

public class Suggester {

	public Suggester(Set<String> words) {
		this.validWords = words;
	}

	Set<String> validWords;

	public static final int MAX_EDIT_DISANCE_THRESHOLD = 2;

	private int validateDistance(int ed) {
		return ed > MAX_EDIT_DISANCE_THRESHOLD ? MAX_EDIT_DISANCE_THRESHOLD : ed;
	}

	private void generate(String s, int idx, int edits, List<String> candidates) {
		if (idx > s.length() || edits == 0) {
			// recursion end
			candidates.add(s);
			return;
		}
		StringBuilder sb = null;

		// don't edit
		generate(s, idx + 1, edits, candidates);

		if (idx != s.length()) {

			// replace
			sb = new StringBuilder(s);
			for (char i = 'a'; i <= 'z'; i++) {
				sb.setCharAt(idx, i);
				generate(sb.toString(), idx + 1, edits - 1, candidates);
			}

			// remove
			sb = new StringBuilder(s);
			generate(sb.deleteCharAt(idx).toString(), idx + 1, edits - 1, candidates);

			// transpose
			char[] arr = s.toCharArray();
			if (idx != s.length() - 1) {
				Util.swap(arr, idx, idx + 1);
				generate(new String(arr), idx + 2, edits - 1, candidates);
			}
		}
		// insert
		for (char i = 'a'; i <= 'z'; i++) {
			sb = new StringBuilder(s);
			generate(sb.insert(idx, i).toString(), idx + 1, edits - 1, candidates);
		}
	}

	public List<String> suggestions(String str, int ed) {
		ed = validateDistance(ed);
		List<String> candidates = new ArrayList<>();
		generate(str, 0, ed, candidates);
		List<String> matches = new ArrayList<>();
		for (String s : candidates) {
			if (validWords.contains(s)) {
				matches.add(s);
			}
		}

		matches = new ArrayList<>(new HashSet<>(matches));
		Collections.sort(matches, new DamerauLevehnsteinDistanceComparator(str));
		return matches;
	}

}
