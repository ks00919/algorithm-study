import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

	static int INF = 9999999;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = parseInt(br.readLine());
		int m = parseInt(br.readLine());

		int[][] array = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = parseInt(st.nextToken());
			int end = parseInt(st.nextToken());

			if (array[start][end] != 0) {
				array[start][end] = Math.min(array[start][end], parseInt(st.nextToken()));
			} else {
				array[start][end] = parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (array[i][j] == 0)
					array[i][j] = INF;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int x = 1; x <= n; x++) {
				for (int y = 1; y <= n; y++) {
					if (i == x || x == y || y == i)
						continue;

					array[x][y] = Math.min(array[x][y], array[x][i] + array[i][y]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(array[i][j] == INF ? 0 : array[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}