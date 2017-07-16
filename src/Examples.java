
import suggester.Keyboard;
import suggester.KeyboardDistanceComparator;
import suggester.Suggester;
import util.WordLists;

public class Examples {

	public static void main(String[] args) throws InterruptedException {

		Suggester s = new Suggester(WordLists.LOWERCASE_WORDS);

		long tic = System.currentTimeMillis();
		System.out.println(s.suggestions("definataly"));
		System.out.println(s.suggestions("ametour"));
		System.out.println(s.suggestions("aceptablle"));
		System.out.println(s.suggestions("acidentaly"));
		System.out.println(s.suggestions("imposible"));
		System.out.println(s.suggestions("spdier"));
		System.out.println(s.suggestions("palidnrome"));
		System.out.println(s.suggestions("nightmar"));
		System.out.println(s.suggestions("cta"));
		System.out.println(s.suggestions("throu"));
		System.out.println(s.suggestions("bier"));
		System.out.println(s.suggestions("brer"));
		System.out.println(Keyboard.keyboardDistance('e', 'e'));
		System.out.println(System.currentTimeMillis() - tic);
		System.out.println(KeyboardDistanceComparator.distance("cat", "act"));
	}
}
