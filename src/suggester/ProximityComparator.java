package suggester;

import java.util.Comparator;

import util.WordLists;

public class ProximityComparator implements Comparator<String> {

	private final String string;

	/**
	 * @param string
	 */
	public ProximityComparator(String string) {
		this.string = string;
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(String arg0, String arg1) {
		int ed1 = EditDistance.damerauLevenshtein(string, arg0);
		int ed2 = EditDistance.damerauLevenshtein(string, arg1);
		if (ed1 == ed2) {
			Integer freq1 = WordLists.freqMap.get(arg0);
			Integer freq2 = WordLists.freqMap.get(arg1);
			if (freq1 == null && freq2 == null) {
				return 0;
			} else if (freq1 == null) {
				return 1;
			} else if (freq2 == null) {
				return -1;
			}
			return WordLists.freqMap.get(arg1) - WordLists.freqMap.get(arg0);
		}
		if (ed1 > ed2) {
			return 1;
		}
		return -1;
	}

}
