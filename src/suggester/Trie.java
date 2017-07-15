package suggester;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Trie {
	public class Node {
		final Node[] children = new Node[Trie.ALPHABET_SIZE];
		boolean isEnd = false;
	}

	/**
	 * the size of the English alphabet
	 */
	public static final int ALPHABET_SIZE = 26;

	/**
	 * starting node of the trie
	 */
	private final Node root;
	/**
	 * The wild card or "don't care' character
	 */
	public static final char WILDCARD = '?';

	/**
	 * Constructs a new empty trie
	 */
	public Trie() {
		root = new Node();
	}

	/* construct the trie from a Collection of Strings */
	public Trie(Collection<String> col) {
		this();
		for (String s : col) {
			this.add(s);
		}
	}

	/* adds a word to the trie */
	public void add(String str) {
		Node curr = root;
		for (int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - 'a';
			curr = curr.children[idx] == null ? (curr.children[idx] = new Node()) : curr.children[idx];
		}
		curr.isEnd = true;
	}

	/* returns a list of all words matching the string with wildcards */
	public List<String> wildcardMatches(String str) {
		List<String> wildcardMatches = new ArrayList<>();
		wildcardTraverse(str, "", root, 0, wildcardMatches);
		return wildcardMatches;
	}

	/*
	 * traverses the trie and adds all words matching the string with wildcards
	 * * to list
	 */
	private void wildcardTraverse(String str, String prefix, Node root, int len,
			List<String> wildcardMatches) {
		if (root == null) {
			return;
		}
		if (len == str.length()) {
			if (root.isEnd) {
				wildcardMatches.add(prefix);
			}
			return;
		}
		if (str.charAt(len) == WILDCARD) {
			for (int i = 0; i < ALPHABET_SIZE; i++) {
				if (root.children[i] != null) {
					wildcardTraverse(str, prefix + (char) ('a' + i), root.children[i], len + 1,
							wildcardMatches);
				}
			}
		} else {
			wildcardTraverse(str, prefix + (str.charAt(len)), root.children[str.charAt(len) - 'a'], len + 1,
					wildcardMatches);
		}
	}

}