import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());

		map = new int[N][N];
		selected = new int[M][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = parseInt(st.nextToken());
			}
		}

		dfs(0, 0, 0);
		System.out.println(distance);
	}

	static int distance = Integer.MAX_VALUE;

	public static void dfs(int depth, int x, int y) {
		if (depth == M) {
			int total = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						total += chickenDistance(i, j);
					}
				}
			}

			distance = Math.min(distance, total);
			return;
		}

		for (int i = x; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) {
					map[i][j] = -1;
					selected[depth] = new int[] { i, j };
					dfs(depth + 1, i, j);
					map[i][j] = 2;
				}
			}
		}
	}

	static int[][] idx = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
	static int[][] selected;

	public static int chickenDistance(int x, int y) {
		int distance = Integer.MAX_VALUE;

		for (int k = 0; k < M; k++) {
			int curr = Math.abs(selected[k][0] - x) + Math.abs(selected[k][1] - y);
			distance = Math.min(distance, curr);
		}

		return distance;
	}

}
