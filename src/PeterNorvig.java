import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PeterNorvig {
	static Set<String> words = new HashSet<>();
	static {
		words.add("cat");
		words.add("dog");
	}

	static Set<String> getConfusionSet(String s) {
		Set<String> confusionSet = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			confusionSet.add(s.substring(0, i) + s.substring(i + 1));
			for (char c = 'a'; c <= 'z'; c++) {
				confusionSet.add(s.substring(0, i) + c + s.substring(i));
				confusionSet.add(s.substring(0, i) + c + s.substring(i + 1));
			}
		}
		confusionSet.retainAll(words);
		return confusionSet;
	}

	static String getBestSuggestion(String word, Map<String, Integer> wordCount) {
		String best = "";
		int max = 0;
		for (String s : getConfusionSet(word)) {
			if (wordCount.containsKey(s) && max < wordCount.get(s)) {
				max = wordCount.get(s);
				best = s;
			}
		}
		return best;
	}

	public static void main(String[] args) {
		System.out.println(getConfusionSet("car"));

	}

}
