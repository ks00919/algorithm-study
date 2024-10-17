import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

	static int N, start;
	static long min = Long.MAX_VALUE;
	static int[][] array;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = parseInt(br.readLine());

		array = new int[N + 1][N + 1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = parseInt(st.nextToken());
			}
		}
		visited = new boolean[N];

		plan();
		System.out.println(min);
	}

	public static void plan() {
		for (start = 0; start < N; start++) {
			visited[start] = true;
			dfs(start, 0, 0l);
		}
	}

	public static void dfs(int n, int depth, long cost) {
		if (cost >= min)
			return;

		if (depth == N - 1) {
			if (array[n][start] > 0) {
				min = Math.min(min, cost + array[n][start]);
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i] && array[n][i] > 0) {
				visited[i] = true;
				dfs(i, depth + 1, cost + array[n][i]);
				visited[i] = false;
			}
		}
	}
}