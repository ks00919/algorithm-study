import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

	static long[] memo;
	static int P = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		factorial();

		int M = parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = parseInt(st.nextToken());
			int k = parseInt(st.nextToken());

			long result = (memo[n] * pow(memo[n - k] * memo[k] % P, P - 2)) % P;
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	public static long pow(long number, long n) {
		if (n == 0)
			return 1;
		long result =

				pow(number, n / 2);
		long next = (result * result) % P;
		return n % 2 == 0 ? next : (next * number) % P;
	}

	public static void factorial() {
		memo = new long[4_000_001];

		memo[0] = 1;
		memo[1] = 1;

		for (int i = 2; i <= 4_000_000; i++) {
			memo[i] = (memo[i - 1] * (i % P)) % P;
		}
	}
}