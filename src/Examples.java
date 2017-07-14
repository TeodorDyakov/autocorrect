

import suggester.Suggester;
import util.WordLists;

public class Examples {

	public static void main(String[] args) throws InterruptedException {

		Suggester s = new Suggester(WordLists.LOWERCASE_WORDS);

		System.out.println(s.suggestions("definataly", 2));
		System.out.println(s.suggestions("ametour", 2));
		System.out.println(s.suggestions("aceptablle", 2));
		System.out.println(s.suggestions("acidentaly", 2));
		System.out.println(s.suggestions("imposible", 2));
		System.out.println(s.suggestions("spdier", 1));
		System.out.println(s.suggestions("palidnrome", 2));
		System.out.println(s.suggestions("nightmar", 1));
		System.out.println(s.suggestions("cta", 1));
		System.out.println(s.suggestions("throu", 2));
	}
}
