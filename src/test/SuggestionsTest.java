package test;

import static org.junit.Assert.*;

import org.junit.Test;

import suggester.Suggester;
import util.WordLists;

public class SuggestionsTest {
	@Test
	public void testFirstSuggestion() {

		Suggester s = new Suggester(WordLists.LOWERCASE_WORDS);

		assertTrue(s.suggestions("impossible").get(0).equals("impossible"));
		assertTrue(s.suggestions("ametour").get(0).equals("amateur"));
		assertTrue(s.suggestions("definataly").get(0).equals("definitely"));
		assertTrue(s.suggestions("cta").get(0).equals("cat"));
		assertTrue(s.suggestions("cratef").contains("crater"));
		assertTrue(s.suggestions("wurld").get(0).equals("world"));
		assertTrue(s.suggestions("smal").get(0).equals("small"));
		assertTrue(s.suggestions("pensil").get(0).equals("pencil"));
	}

	@Test
	public void testContains() {

		Suggester s = new Suggester(WordLists.LOWERCASE_WORDS);

		assertTrue(s.suggestions("cofe").contains("core"));
		assertTrue(s.suggestions("cofe").contains("code"));

		assertTrue(s.suggestions("spdier").contains("spider"));
		assertTrue(s.suggestions("spdier").contains("spier"));

		assertTrue(s.suggestions("carg").contains("cart"));
		assertTrue(s.suggestions("carg").contains("cargo"));
		assertTrue(s.suggestions("carg").contains("card"));
	}

}
