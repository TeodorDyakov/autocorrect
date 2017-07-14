package suggester;

import java.util.Comparator;

public class DamerauLevehnsteinDistanceComparator implements Comparator<String> {
	private final String string;

	public DamerauLevehnsteinDistanceComparator(String string) {
		this.string = string;
	}

	@Override
	public int compare(String arg0, String arg1) {
		return DamerauLevehnsteinDistance.calculateDistance(string, arg0)
				- DamerauLevehnsteinDistance.calculateDistance(string, arg1);
	}
}
