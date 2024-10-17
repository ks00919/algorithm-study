import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int M = parseInt(st.nextToken());

			int[][] D = new int[M + 1][N + 1];

			for (int i = 0; i <= M; i++) {
				for (int j = 0, end = Math.min(i, N); j <= end; j++) {
					if (j == 0 || i == j)
						D[i][j] = 1;
					else
						D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
				}
			}
			sb.append(D[M][N]).append("\n");
		}

		System.out.println(sb);
	}
}
