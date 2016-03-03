package editDistance;

public class EditDistance {

	public static int minDistance(String freeman1, String freeman2) {
		int len1 = freeman1.length();
		int len2 = freeman2.length();
		int[][] poids = { { 0, 1, 2, 3, 4, 3, 2, 1 },
				{ 1, 0, 1, 2, 3, 4, 3, 2 }, { 2, 1, 0, 1, 2, 3, 4, 3 },
				{ 3, 2, 1, 0, 1, 2, 3, 4 }, { 4, 3, 2, 1, 0, 1, 2, 3 },
				{ 3, 4, 3, 2, 1, 0, 1, 2 }, { 2, 3, 4, 3, 2, 1, 0, 1 },
				{ 1, 2, 3, 4, 3, 2, 1, 0 } };

		// len1+1, len2+1, because finally return dp[len1][len2]
		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}

		// iterate though, and check last char
		for (int i = 0; i < len1; i++) {
			char c1 = freeman1.charAt(i);
			for (int j = 0; j < len2; j++) {
				char c2 = freeman2.charAt(j);

				// if last two chars equal
				if (c1 == c2) {
					// update dp value for +1 length
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int replace = dp[i][j] + 2;

					if (poids[Character.getNumericValue(c1)][Character
							.getNumericValue(c2)] == 1) {
						replace = dp[i][j] + 1;
					} else if (poids[Character.getNumericValue(c1)][Character
							.getNumericValue(c2)] == 2
							|| poids[Character.getNumericValue(c1)][Character
									.getNumericValue(c2)] == 3) {
						replace = dp[i][j] + 2;
					} else if (poids[Character.getNumericValue(c1)][Character
							.getNumericValue(c2)] == 4) {
						replace = dp[i][j] + 3;
					}
					
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;
			
					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}

		return dp[len1][len2];
	}

	public static void main(String[] args) {
		System.out.println("ED : " + minDistance("0", "4"));
	}

}
