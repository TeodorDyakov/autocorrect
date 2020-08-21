# spell-checker
A simple spell checking engine that suggests a correction to a mispelled word

    	Suggester s = new Suggester(WordLists.LOWERCASE_WORDS);

	System.out.println(s.suggestions("definataly"));
	// [definitely, defiantly, definably]

