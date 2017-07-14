package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordLists {

	public static Set<String> LOWERCASE_WORDS = new HashSet<>();

	static Scanner reader;
	static {
		try {
			reader = new Scanner(new File("words.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (reader.hasNext()) {
			String str = reader.next();
			if (str.matches("[a-zA-Z]+")) {
				LOWERCASE_WORDS.add(str.toLowerCase());
			}
		}
	}
}
