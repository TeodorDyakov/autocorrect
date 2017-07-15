package suggester;

import java.util.Comparator;

import util.Util;

public class KeyboardDistanceComparator implements Comparator<String> {

	public KeyboardDistanceComparator(String value) {
		this.value = value;
	}

	private String value;

	public static double distance(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		double dp[][] = new double[m + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			dp[0][i] = i;
		}
		for (int i = 0; i <= m; i++) {
			dp[i][0] = i;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = Util.min(1 + dp[i][j - 1], 1 + dp[i - 1][j],
							0.5 * Keyboard.keyboardDistance(str1.charAt(i - 1), str2.charAt(j - 1))
									+ (dp[i - 1][j - 1]));
			}
		}
		return dp[m][n];
	}

	@Override
	public int compare(String arg0, String arg1) {
		if (Math.abs(distance(arg0, value) - distance(value, arg1)) < .000000001) {
			return 0;
		}
		if (distance(arg0, value) > distance(value, arg1)) {
			return 1;
		}
		return -1;
	}

}
