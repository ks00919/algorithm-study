import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int h, w;
	public static int[][] cheese;
	public static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = parseInt(st.nextToken());
		w = parseInt(st.nextToken());

		cheese = new int[h][w];

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				cheese[i][j] = parseInt(st.nextToken());
			}
		}

		int hour = 0;
		int count = 1;

		do {
			simulate();
			hour++;
		} while ((count = count()) > 0);

		StringBuilder sb = new StringBuilder();
		sb.append(hour).append("\n");
		sb.append(count * -1);
		System.out.println(sb);
	}

	public static void simulate() {
		visited = new boolean[h][w];

		for (int i = 0; i < h; i++) {
			if (i == 0 || i == h - 1) { // 배열의 첫 줄과 마지막 줄
				for (int j = 0; j < w; j++) {
					if (!visited[i][j]) {
						dfs(i, j);
					}
				}
			} else {
				if (!visited[i][0])
					dfs(i, 0);
				if (!visited[i][w - 1])
					dfs(i, w - 1);
			}
		}
	}

	static int[][] idx = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	public static void dfs(int x, int y) {
		visited[x][y] = true;

		if (cheese[x][y] == 1) {
			cheese[x][y] = -1;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int dx = x + idx[i][0];
			int dy = y + idx[i][1];

			if (dx < 0 || dy < 0 || dx >= h || dy >= w || visited[dx][dy]) {
				continue;
			}

			if (cheese[dx][dy] != -1)
				dfs(dx, dy);
		}

	}

	public static int count() {
		int count = 0;
		int melt = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (cheese[i][j] == 1)
					count++;

				if (cheese[i][j] == -1) {
					cheese[i][j] = 0;
					melt--;
				}
			}
		}
		return count == 0 ? melt : count;
	}
}
