import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;

	static class Pair {
		int x, y;
		int time;

		public Pair(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = parseInt(st.nextToken());
		C = parseInt(st.nextToken());

		int[][] time = new int[R][C];
		Queue<Pair> q = new ArrayDeque<>();

		Pair jh = null;

		for (int i = 0; i < R; i++) {
			String input = br.readLine();

			for (int j = 0; j < C; j++) {
				char c = input.charAt(j);

				if (c == 'F') {
					q.add(new Pair(i, j, 0));
					time[i][j] = -1;
				} else if (c == 'J') {
					jh = new Pair(i, j, 0);
				} else if (c == '#') {
					time[i][j] = -1;
				}
			}
		}

		fire(time, q);

		int total = escape(time, jh);
		System.out.println(total == -1 ? "IMPOSSIBLE" : total);
	}

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void fire(int[][] time, Queue<Pair> q) {

		while (!q.isEmpty()) {
			Pair curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];

				if (x < 0 || y < 0 || x >= R || y >= C || time[x][y] != 0)
					continue;

				time[x][y] = curr.time + 1;

				q.add(new Pair(x, y, curr.time + 1));
			}
		}
	}

	public static int escape(int[][] time, Pair jh) {
		Queue<Pair> q = new ArrayDeque<>();
		q.add(jh);

		Pair curr = jh;
		boolean flag = false;

		boolean[][] visited = new boolean[R][C];

		while (!q.isEmpty()) {
			curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];

				if (x < 0 || y < 0 || x >= R || y >= C) {
					flag = true;
					break;
				}

				if (time[x][y] <= curr.time + 1 && time[x][y] != 0)
					continue;

				if (visited[x][y])
					continue;

				visited[x][y] = true;
				q.add(new Pair(x, y, curr.time + 1));
			}

			if (flag)
				break;
		}

		return !flag ? -1 : curr.time + 1;
	}

}
