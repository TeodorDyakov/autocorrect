package suggester;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Trie {
	public class Node {
		final Map<Character, Node> children;
		boolean isEnd;

		Node() {
			/*
			 * 0 initial capacity to reduce memory use
			 */
			children = new HashMap<>(0);
			isEnd = false;
		}

	}

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
			if (curr.children.get(str.charAt(i)) == null) {
				curr.children.put(str.charAt(i), new Node());
			}
			curr = curr.children.get(str.charAt(i));
		}
		curr.isEnd = true;
	}

	/* returns a list of all words matching the string with wildcards */
	public List<String> wildcardMatches(String str) {
		List<String> wildcardMatches = new ArrayList<>();
		wildcardTraverse(str, new StringBuilder(), root, 0, wildcardMatches);
		return wildcardMatches;
	}

	/*
	 * traverses the trie and adds all words matching the string with wildcards
	 * * to list
	 */
	private void wildcardTraverse(String pattern, StringBuilder prefix, Node root, int len,
			List<String> wildcardMatches) {
		if (root == null) {
			return;
		}
		if (len == pattern.length()) {
			if (root.isEnd) {
				wildcardMatches.add(prefix.toString());
			}
			return;
		}
		if (pattern.charAt(len) == WILDCARD) {
			for (Entry<Character, Node> e : root.children.entrySet()) {
				prefix.append(e.getKey());
				wildcardTraverse(pattern, prefix, e.getValue(), len + 1, wildcardMatches);
				prefix.deleteCharAt(prefix.length() - 1);
			}
		} else {
			prefix.append(pattern.charAt(len));
			wildcardTraverse(pattern, prefix, root.children.get(pattern.charAt(len)), len + 1,
					wildcardMatches);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}

	private Node getNode(String str) {
		Node node = root;
		for (int i = 0; i < str.length(); i++) {
			Node child = node.children.get(str.charAt(i));
			if (child == null) {
				return null;
			}
			node = child;
		}
		return node;
	}

	public List<String> prefixedWords(String str) {
		Node curr = getNode(str);
		List<String> prefixedWords = new ArrayList<>();
		DFS(curr, str, prefixedWords);
		return prefixedWords;
	}

	/* traverses the trie depth first and adds all words to list */
	private static void DFS(Node root, String prefix, List<String> list) {
		if (root == null) {
			return;
		}
		if (root.isEnd) {
			list.add(prefix);
		}
		for (Entry<Character, Node> e : root.children.entrySet()) {
			DFS(e.getValue(), prefix + e.getKey(), list);
		}
	}

}