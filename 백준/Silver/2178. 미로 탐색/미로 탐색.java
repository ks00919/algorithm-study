import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

	static class Location {
		int x, y, count;

		public Location(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	static int[] dx = { 0, 1, -1, 0 };
	static int[] dy = { 1, 0, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());
		int M = parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		System.out.println(bfs(map, N, M));

	}

	public static int bfs(int[][] map, int N, int M) {
		Queue<Location> q = new ArrayDeque<>();
		q.add(new Location(0, 0, 1));

		while (!q.isEmpty()) {
			Location curr = q.poll();
			if (curr.x == N - 1 && curr.y == M - 1)
				return curr.count;

			for (int i = 0; i < 4; i++) {
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];

				if (x < 0 || x >= N || y < 0 || y >= M || map[x][y] != 1)
					continue;
				map[x][y] = 0;
				q.add(new Location(x, y, curr.count + 1));
			}
		}
		return -1;
	}
}