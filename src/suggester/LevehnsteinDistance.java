package suggester;

import util.Util;

public class LevehnsteinDistance {

	public static int distance(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int dp[][] = new int[m + 1][n + 1];
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
					dp[i][j] = 1 + Util.min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
			}
		}
		return dp[m][n];
	}

}
