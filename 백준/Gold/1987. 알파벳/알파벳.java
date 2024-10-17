import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] alphabet;
	static int[] isUsed = new int[26];
	static int[][] idx = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = parseInt(st.nextToken());
		C = parseInt(st.nextToken());

		alphabet = new char[R][C];
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				alphabet[i][j] = input.charAt(j);
			}
		}

		if (R == C && R == 1) {
			System.out.println(1);
		} else {
			dfs(0, 0, 0);
			System.out.println(max);
		}
	}

	static int max;

	public static void dfs(int count, int x, int y) {
		int c = alphabet[x][y] - 'A';

		if (isUsed[c] != 0) {
			max = Math.max(max, count);
			return;
		}

		isUsed[alphabet[x][y] - 'A']++;
		for (int i = 0; i < 4; i++) {
			int dx = x + idx[i][0];
			int dy = y + idx[i][1];

			if (dx < 0 || dy < 0 || dx >= R || dy >= C)
				continue;

			dfs(count + 1, dx, dy);
		}
		isUsed[c]--;
	}
}
