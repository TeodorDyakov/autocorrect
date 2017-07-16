package suggester;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Keyboard {

	final static String[] KEYBOARD_ROWS = new String[] { "1234567890-+", "qwertyuiop[]", "asdfghjkl;'\\",
			"zxcvbnm,./" };

	final static Map<Character, Point> letterToPosition = new HashMap<>();

	static {
		for (int i = 0; i < Keyboard.KEYBOARD_ROWS.length; i++) {
			final String row = Keyboard.KEYBOARD_ROWS[i];
			for (int j = 0; j < row.length(); j++) {
				letterToPosition.put(row.charAt(j), new Point(i, j));
			}
		}
	}
	// beeerop

	public static double keyboardDistance(char letter1, char letter2) {
		return Keyboard.letterToPosition.get(letter1).distance(Keyboard.letterToPosition.get(letter2));
	}

}
