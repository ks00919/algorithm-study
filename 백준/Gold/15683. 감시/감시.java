import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int min = Integer.MAX_VALUE;
	static int[][] map;
	static int[] selected;
	static List<Location> cctv;
	static int[][] idx = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static class Location {
		int x;
		int y;

		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());

		map = new int[N][M];
		cctv = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = parseInt(st.nextToken());

				if (map[i][j] != 0 && map[i][j] != 6) {
					cctv.add(new Location(i, j));
				}
			}
		}

		selected = new int[cctv.size()];
		dfs(cctv.size(), 0);

		System.out.println(min);
	}

	public static void dfs(int number, int depth) {
		if (depth == number) {
			simulate();
			return;
		}

		for (int i = 0; i < 4; i++) {
			selected[depth] = i;
			dfs(number, depth + 1);
		}
	}

	public static void simulate() {
		int[][] matrix = new int[N][];
		for (int i = 0; i < N; i++) {
			matrix[i] = Arrays.copyOf(map[i], M);
		}

		for (int i = 0; i < cctv.size(); i++) {
			int x = cctv.get(i).x;
			int y = cctv.get(i).y;
			int number = map[x][y];

			if (number == 1) {

				turnOn(matrix, selected[i], x, y);

			} else if (number == 2) {

				turnOn(matrix, selected[i], x, y);
				turnOn(matrix, selected[i] >= 2 ? selected[i] - 2 : selected[i] + 2, x, y);

			} else if (number == 3 || number == 4) {
				for (int j = 0; j < number - 1; j++) {
					int select = selected[i] + j > 3 ? selected[i] + j - 4 : selected[i] + j;
					turnOn(matrix, select, x, y);
				}

			} else if (number == 5) {
				for (int j = 0; j < 4; j++) {
					turnOn(matrix, j, x, y);
				}
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == 0)
					count++;
			}
		}

		min = Math.min(min, count);
	}

	public static void turnOn(int matrix[][], int index, int x, int y) {
		int dx = idx[index][0];
		int dy = idx[index][1];

		while (true) {
			if (x < 0 || y < 0 || x >= N || y >= M)
				break;

			if (matrix[x][y] == 6)
				break;

			matrix[x][y] = 7;

			x += dx;
			y += dy;
		}
	}

}
