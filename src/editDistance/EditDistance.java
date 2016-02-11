package editDistance;

public class EditDistance {

	public static int minDistance(String freeman1, String freeman2) {
		int len1 = freeman1.length();
		int len2 = freeman2.length();

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
		System.out.println("ED : " + minDistance("322444444444444444444444444444444444444444444444444444444444444444444444454454444444444466660000000000000100100000000000000000000000000000000000000000000000000000000000075654656565565565555554554544666600071021101101021022121121102121211211021", "222222322323232232222232232323222222222222322222222222322232232222222224444444545555455555455554454455455322222222222222222444466666666666666666666554545454454454445444454455443545354454444666600071001007100100110010001000010010101010766666666666666600002222222222222222221101101100100110111111011101107665766676676766666666667666666666576676767667666667667676766766660000"));
	}

}
