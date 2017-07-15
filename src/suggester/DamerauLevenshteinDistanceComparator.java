package suggester;

import java.util.Comparator;

public class DamerauLevenshteinDistanceComparator implements Comparator<String> {
	private final String string;

	public DamerauLevenshteinDistanceComparator(String string) {
		this.string = string;
	}

	@Override
	public int compare(String arg0, String arg1) {
		return EditDistance.damerauLevenshtein(string, arg0)
				- EditDistance.damerauLevenshtein(string, arg1);
	}
}
