import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = parseInt(br.readLine());
		int dp[] = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int tc = 0; tc < T; tc++) {
			int n = parseInt(br.readLine());

			for (int i = 4; i <= n; i++) {
				if (dp[i] == 0) {
					dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
				}
			}

			sb.append(dp[n]).append("\n");
		}

		System.out.println(sb);
	}

}