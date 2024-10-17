import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

	static long[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = parseInt(br.readLine());
		memo = new long[101];
		for (int i = 1; i < 4; i++) {
			memo[i] = 1;
		}

		for (int tc = 1; tc <= T; tc++) {
			int N = parseInt(br.readLine());
			sb.append(getLength(N)).append("\n");
		}
		System.out.println(sb);

	}

	public static long getLength(int n) {
		if (n <= 3 || memo[n] != 0)
			return memo[n];
		return memo[n] = getLength(n - 2) + getLength(n - 3);
	}
}