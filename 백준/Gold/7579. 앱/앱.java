import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = parseInt(st.nextToken());
		int M = parseInt(st.nextToken());

		int[] m = new int[N + 1];
		int[] c = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			m[i] = parseInt(st.nextToken());
			c[i] = parseInt(st2.nextToken());
		}

		int[][] dp = new int[N + 1][10001];

		for (int price = 0; price < 10001; price++) {
			for (int i = 1; i <= N; i++) {
				if (price - c[i] >= 0) {
					dp[i][price] = Math.max(dp[i - 1][price], dp[i - 1][price - c[i]] + m[i]);
				} else {
					dp[i][price] = dp[i - 1][price];
				}
			}

			if (dp[N][price] >= M) {
				System.out.println(price);
				break;
			}
		}
	}
}
