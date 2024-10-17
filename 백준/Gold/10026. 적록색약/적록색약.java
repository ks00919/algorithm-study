import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static char[][] array;
	static boolean[][] visited;
	static int[][] idx = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = parseInt(br.readLine());
		array = new char[N][N];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				array[i][j] = input.charAt(j);
			}
		}
		visited = new boolean[N][N];

		int red = 0;
		int green = 0;
		int blue = 0;
		int rg = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (!visited[i][j]) {
					if (array[i][j] == 'B') {
						dfs('B', i, j);
						blue++;
					} else if (array[i][j] == 'G') {
						dfs('G', i, j);
						green++;
					} else if (array[i][j] == 'R') {
						dfs('R', i, j);
						red++;
					}
				}
			}
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ((array[i][j] == 'G' || array[i][j] == 'R') && !visited[i][j]) {
					dfs(i, j);
					rg++;
				}
			}
		}
		System.out.printf("%d %d", red + green + blue, blue + rg);
	}

	public static void dfs(char color, int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int dx = x + idx[i][0];
			int dy = y + idx[i][1];

			if (dx < 0 || dy < 0 || dx >= N || dy >= N)
				continue;

			if (array[dx][dy] == color && !visited[dx][dy])
				dfs(color, dx, dy);
		}
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int dx = x + idx[i][0];
			int dy = y + idx[i][1];

			if (dx < 0 || dy < 0 || dx >= N || dy >= N)
				continue;

			if ((array[dx][dy] == 'R' || array[dx][dy] == 'G') && !visited[dx][dy])
				dfs(dx, dy);
		}
	}

}
