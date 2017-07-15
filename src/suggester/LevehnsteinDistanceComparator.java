package suggester;

import java.util.Comparator;

public class LevehnsteinDistanceComparator implements Comparator<String> {

	private final String string;

	public LevehnsteinDistanceComparator(String string) {
		this.string = string;
	}

	@Override
	public int compare(String arg0, String arg1) {
		return EditDistance.levehnstein(string, arg0)
				- EditDistance.levehnstein(string, arg1);
	}	

}
