import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo = new int[N + 1];

		if (N > 1)
			memo[2] = 1;
		if (N > 2)
			memo[3] = 1;

		for (int i = 4; i < memo.length; i++) {
			int minus = memo[i - 1] + 1;

			int two = Integer.MAX_VALUE;
			int three = Integer.MAX_VALUE;

			if (i % 2 == 0) {
				two = memo[i / 2] + 1;
			}

			if (i % 3 == 0) {
				three = memo[i / 3] + 1;
			}

			memo[i] = Math.min(minus, Math.min(two, three));
		}

		System.out.println(memo[N]);
	}
}