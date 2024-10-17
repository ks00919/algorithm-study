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

	static int R, C;
	static char[][] map;
	static Location hog, beaver;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = parseInt(st.nextToken());
		C = parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);

				if (map[i][j] == 'S') {
					hog = new Location(i, j, 0);
				} else if (map[i][j] == 'D')
					beaver = new Location(i, j, 0);
			}
		}

		Location result = bfs();
		System.out.println(result == null ? "KAKTUS" : result.count);
	}

	public static Location bfs() {
		Queue<Location> q = new ArrayDeque<>();
		q.add(hog);

		int time = 0;
		while (!q.isEmpty()) {
			Location curr = q.poll();

			if (curr.x == beaver.x && curr.y == beaver.y)
				return curr;

			if (curr.count != time) {
				time++;
				flood();
			}

			if (map[curr.x][curr.y] == '*')
				continue;

			for (int i = 0; i < 4; i++) {
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];

				if (x < 0 || y < 0 || x >= R || y >= C)
					continue;
				if (map[x][y] != '.' && map[x][y] != 'D')
					continue;
				map[x][y] = 'S';
				q.add(new Location(x, y, curr.count + 1));
			}

//			System.out.println(curr.count);
//			for (int i = 0; i < R; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
		}

		return null;
	}

	public static void flood() {
		char[][] copy = new char[R][C];
		for (int i = 0; i < R; i++) {
			copy[i] = Arrays.copyOf(map[i], C);
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*') {
					for (int k = 0; k < 4; k++) {
						int x = i + dx[k];
						int y = j + dy[k];

						if (x < 0 || x >= R || y < 0 || y >= C)
							continue;
						if (map[x][y] == 'X' || map[x][y] == 'D')
							continue;
						copy[x][y] = '*';
					}
				}
			}
		}

		map = copy;
	}
}