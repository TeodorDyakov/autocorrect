# spell-checker
A simple spell checking engine that suggests a correction to a mispelled word

    Suggester s = new Suggester(WordLists.LOWERCASE_WORDS);

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

		System.out.println(s.suggestions("cta"));
		// [cat, ta, ca, acta, eta]

		System.out.println(s.suggestions("brer"));
		// [beer, bred, bier, boer, brey]
