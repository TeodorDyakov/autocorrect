package suggester;

import java.util.Comparator;

public class LevehnshteinDistanceComparator implements Comparator<String> {

	private final String string;

	public LevehnshteinDistanceComparator(String string) {
		this.string = string;
	}

	@Override
	public int compare(String arg0, String arg1) {
		return EditDistance.levenshtein(string, arg0)
				- EditDistance.levenshtein(string, arg1);
	}	

}
