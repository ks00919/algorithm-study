import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int h, w;
	static int[][] idx = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String input = br.readLine();

			if (input.equals("0 0"))
				break;

			StringTokenizer st = new StringTokenizer(input);
			w = parseInt(st.nextToken());
			h = parseInt(st.nextToken());

			map = new int[h][w];
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = parseInt(st.nextToken());
				}
			}

			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int x, int y) {

		visited[x][y] = true;

		for (int i = 0; i < 8; i++) {
			int dx = x + idx[i][0];
			int dy = y + idx[i][1];

			if (dx < 0 || dy < 0 || dx >= h || dy >= w || visited[dx][dy])
				continue;

			if (map[dx][dy] == 1)
				dfs(dx, dy);
		}

	}
}
