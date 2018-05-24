
import suggester.Suggester;
import util.WordLists;

public class Examples {

	public static void main(String[] args) throws InterruptedException {

		Suggester s = new Suggester(WordLists.LOWERCASE_WORDS);

		System.out.println(s.autocomplete("ca"));
		// [came, can, case, carried, cause]

		System.out.println(s.autocomplete("carto"));
		// [cartoon, cartobibliography, cartouche, cartomancy, carton]

		System.out.println(s.suggestions("definataly"));
		// [definitely, defiantly, definably]

		System.out.println(s.suggestions("ametour"));
		// [amateur, detour, retour, ametrous, acetous]

		System.out.println(s.suggestions("aceptablle"));
		// [acceptable]

		System.out.println(s.suggestions("acidentaly"));
		// [accidental, accidentally, accidently]

		System.out.println(s.suggestions("imposible"));
		// [impossible, imposable, impassible, impedible, impatible]

		System.out.println(s.suggestions("spdier"));
		// [spider, sprier, spier, soldier, pier]

		System.out.println(s.suggestions("nightmar"));
		// [nightmare, nightmary, nightman, nightjar, nightcap]

		System.out.println(s.suggestions("cta"));
		// [cat, ta, ca, acta, eta]

		System.out.println(s.suggestions("throu"));
		// [throu, throw, thou, throb, throe]

		System.out.println(s.suggestions("bier"));
		// [bier, tier, beer, pier, bien]

		System.out.println(s.suggestions("brer"));
		// [beer, bred, bier, boer, brey]
		
		//test
	}
}
