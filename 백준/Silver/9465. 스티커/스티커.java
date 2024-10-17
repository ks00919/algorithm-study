import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = parseInt(br.readLine());
			int[][] stickers = new int[2][n + 1];

			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					stickers[i][j] = parseInt(st.nextToken());
				}
			}

			if (n == 1) {
				sb.append(Math.max(stickers[0][1], stickers[1][1])).append("\n");
				continue;
			}

			int[][] dp = new int[2][n + 1];
			dp[0][1] = stickers[0][1];
			dp[1][1] = stickers[1][1];
			for (int i = 2; i <= n; i++) {
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i];
			}

			sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
		}
		System.out.println(sb);
	}
}