import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());

		int[] budgets = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < N; i++) {
			budgets[i] = parseInt(st.nextToken());
			sum += budgets[i];
		}
		int budget = parseInt(br.readLine());
		Arrays.sort(budgets);

		if (budget == sum) {
			System.out.println(budgets[N - 1]);
			System.exit(0);
		}

		int min = 0;
		int max = budgets[N - 1];

		while (min <= max) {
			sum = 0;
			int limit = (min + max) / 2;

			for (int i = 0; i < N; i++) {
				sum += Math.min(limit, budgets[i]);
			}

			if (sum <= budget) {
				min = limit + 1;
			} else {
				max = limit - 1;
			}
		}

		System.out.println(max);
	}
}