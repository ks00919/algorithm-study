import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long[] memo0;
	static long[] memo1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			int N = parseInt(br.readLine());
			memo0 = new long[N + 1];
			memo1 = new long[N + 1];

			memo0[0] = 1;

			if (N >= 1)
				memo1[1] = 1;

			if (N > 1) {
				fibo(N);
			}

			sb.append(memo0[N]).append(" ").append(memo1[N]).append("\n");
		}
		System.out.println(sb);
	}

	static void fibo(int n) {
		if (memo0[n - 1] == 0 && memo1[n - 1] == 0) {
			fibo(n - 1);
		}

		memo0[n] = memo0[n - 1] + memo0[n - 2];
		memo1[n] = memo1[n - 1] + memo1[n - 2];
	}
}
