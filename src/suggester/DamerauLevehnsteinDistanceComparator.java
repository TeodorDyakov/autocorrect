package suggester;

import java.util.Comparator;

public class DamerauLevehnsteinDistanceComparator implements Comparator<String> {
	private final String string;

	public DamerauLevehnsteinDistanceComparator(String string) {
		this.string = string;
	}

	@Override
	public int compare(String arg0, String arg1) {
		return EditDistance.damerauLevehnstein(string, arg0)
				- EditDistance.damerauLevehnstein(string, arg1);
	}
}
