import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = parseInt(st.nextToken());
		int N = parseInt(st.nextToken());
		int H = parseInt(st.nextToken());

		int[][][] boxes = new int[H][N][M];
		Queue<int[]> q = new ArrayDeque<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					boxes[i][j][k] = parseInt(st.nextToken());

					if (boxes[i][j][k] == 1)
						q.add(new int[] { i, j, k, 0 });
				}
			}
		}

		if (q.size() == N * M * H) {
			System.out.println(0);
			return;
		}

		// 6방 탐색
		int[][] idx = { { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { -1, 0, 0 }, { 1, 0, 0 } };

		int[] location = null;
		while (!q.isEmpty()) {
			location = q.poll();

			int z = location[0];
			int x = location[1];
			int y = location[2];

			for (int i = 0; i < 6; i++) {
				int dz = z + idx[i][0];
				int dx = x + idx[i][1];
				int dy = y + idx[i][2];

				if (dz < 0 || dx < 0 || dy < 0 || dz >= H || dx >= N || dy >= M)
					continue;

				if (boxes[dz][dx][dy] == 0) {
					q.add(new int[] { dz, dx, dy, location[3] + 1 });
					boxes[dz][dx][dy] = 1;
				}
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (boxes[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}

		System.out.println(location[3]);
	}

}
