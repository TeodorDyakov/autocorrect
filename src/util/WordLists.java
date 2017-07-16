package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordLists {

	public static Set<String> LOWERCASE_WORDS = new HashSet<>();
	public static Map<String, Integer> freqMap = new HashMap<>();
	public static Set<String> BULGARIAN_LOWERCASE_WORDS = new HashSet<>();

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

		try {
			reader = new Scanner(new File("Bulgarian.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (reader.hasNext()) {
			String str = reader.next().replaceAll("[^а-яА-Я]+", "");
			BULGARIAN_LOWERCASE_WORDS.add(str.toLowerCase());
		}

		try {
			reader = new Scanner(new File("big.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (reader.hasNext()) {
			String str = reader.next().toLowerCase();
			freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
		}
	}
}
