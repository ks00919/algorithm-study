import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N, M;
	public static int[][] iceberg;
	public static int[][] idx = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());

		iceberg = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				iceberg[i][j] = parseInt(st.nextToken());
			}
		}

		System.out.println(melt());
	}

	public static int melt() {

		int year = 0;
		int count = 1;

		while (count == 1) {

			int[][] temp = new int[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (iceberg[i][j] > 0) {
						temp[i][j] = iceberg[i][j] - countSea(i, j);
						if (temp[i][j] < 0)
							temp[i][j] = 0;
					}
				}
			}

			iceberg = temp;

			count = countIce();
			year++;
		}

		return count == 0 ? 0 : year;
	}

	public static int countSea(int x, int y) {
		int count = 0;

		for (int i = 0; i < 4; i++) {
			int dx = x + idx[i][0];
			int dy = y + idx[i][1];

			if (dx < 0 || dy < 0 || dx >= N || dy >= M)
				continue;
			if (iceberg[dx][dy] == 0)
				count++;
		}

		return count;
	}

	public static int countIce() {

		boolean[][] visited = new boolean[N][M];
		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (iceberg[i][j] == 0 || visited[i][j])
					continue;
				bfs(visited, i, j);
				count++;
			}
		}

		return count;
	}

	public static void bfs(boolean[][] visited, int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] coordinate = q.poll();

			for (int i = 0; i < 4; i++) {
				int dx = coordinate[0] + idx[i][0];
				int dy = coordinate[1] + idx[i][1];

				if (dx < 0 || dy < 0 || dx >= N || dy >= M || visited[dx][dy])
					continue;

				if (iceberg[dx][dy] > 0) {
					visited[dx][dy] = true;
					q.offer(new int[] { dx, dy });
				}
			}

		}
	}
}