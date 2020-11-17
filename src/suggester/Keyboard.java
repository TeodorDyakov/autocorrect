package suggester;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	/**
	 * @param letter
	 * @return
	 */
	public static List<Character> getClosestKeys(char letter) {
		List<Character> closest = new ArrayList<>();
		Point coord = letterToPosition.get(letter);
		int x = (int) coord.getX();
		int y = (int) coord.getY();
		if (x - 1 >= 0 && y < KEYBOARD_ROWS[x - 1].length()) {
			closest.add(KEYBOARD_ROWS[x - 1].charAt(y));
		}
		if (x + 1 < KEYBOARD_ROWS.length && y < KEYBOARD_ROWS[x + 1].length()) {
			closest.add(KEYBOARD_ROWS[x + 1].charAt(y));
		}
		if (y - 1 >= 0) {
			closest.add(KEYBOARD_ROWS[x].charAt(y - 1));
		}
		if (y + 1 < KEYBOARD_ROWS[x].length()) {
			closest.add(KEYBOARD_ROWS[x].charAt(y + 1));
		}
		return closest;
	}

	public static boolean areNeighbours(char c, char d) {
		return getClosestKeys(c).contains(d);
	}

	/**
	 * @param letter1
	 * @param letter2
	 * @return
	 */
	public static double keyboardDistance(char letter1, char letter2) {
		return Keyboard.letterToPosition.get(letter1).distance(Keyboard.letterToPosition.get(letter2));
	}

}
