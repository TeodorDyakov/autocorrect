# spell-checker
A simple spell checking engine that suggests a correction to a mispelled word. Words are ranked first by Levenstein distance, than by probability of unigram.
```java
    	Suggester s = new Suggester(WordLists.LOWERCASE_WORDS);

		System.out.println(s.suggestions("definataly"));
		// [definitely, defiantly, definably]
```
