package test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import suggester.Suggester;
import util.WordLists;

public class SuggesterTest {

	@Test
	public void testGetCandidates1() {
		Suggester fm = new Suggester(WordLists.LOWERCASE_WORDS);
		Set<String> can = fm.getCandidates("a", 1);
		Set<String> expected = new HashSet<>();
		expected.add("a");
		expected.add("");
		expected.add("a?");
		expected.add("?a");
		expected.add("?");
		assertEquals(new TreeSet<>(expected), new TreeSet<>(can));
	}

	@Test
	public void testGetCandidates2() {
		Suggester fm = new Suggester(WordLists.LOWERCASE_WORDS);
		Set<String> can = fm.getCandidates("a", 2);
		Set<String> expected = new HashSet<>();
		expected.add("a");
		expected.add("??");
		expected.add("a?");
		expected.add("?a");
		expected.add("?");
		expected.add("??");
		expected.add("a??");
		expected.add("?a?");
		expected.add("??a");
		expected.add("");
		assertEquals(new TreeSet<>(expected), new TreeSet<>(can));
	}

	@Test
	public void testGetCandidates4() {
		Suggester fm = new Suggester(WordLists.LOWERCASE_WORDS);
		Set<String> can = fm.getCandidates("", 2);
		Set<String> expected = new HashSet<>();
		expected.add("");
		expected.add("??");
		expected.add("?");
		assertEquals(new TreeSet<>(expected), new TreeSet<>(can));
	}

	@Test
	public void testGetCandidates5() {
		Suggester fm = new Suggester(WordLists.LOWERCASE_WORDS);
		Set<String> can = fm.getCandidates("cat", 1);
		Set<String> expected = new HashSet<>();
		expected.add("ca?");
		expected.add("ca");
		expected.add("at");
		expected.add("ct");
		expected.add("?at");
		expected.add("c?t");
		expected.add("cat?");
		expected.add("ca?t");
		expected.add("c?at");
		expected.add("?cat");
		expected.add("cat");
		expected.add("cta");
		expected.add("act");
		assertEquals(new TreeSet<>(expected), new TreeSet<>(can));
	}
}
