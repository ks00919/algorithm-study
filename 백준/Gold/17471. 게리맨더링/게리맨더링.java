import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int total;
	static int[] population;
	static int[][] map;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = parseInt(br.readLine());

		population = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = parseInt(st.nextToken());
			total += population[i];
		}

		selected = new int[N + 1];

		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = parseInt(st.nextToken());

			for (int j = 0; j < n; j++) {
				int to = parseInt(st.nextToken());
				map[i][to] = 1;
				map[to][i] = 1;
			}
		}

		dfs(1, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

		selected = new int[] { 0, 1, 0, 0, 1, 0, 0 };
	}

	static int[] selected;

	public static void dfs(int depth, int count) {
		if (count == N)
			return;

		if (depth == N + 1) {
			if (count == 0)
				return;

			if (isValid(count)) {
				calculate();
			}

			return;
		}

		selected[depth] = 1;
		dfs(depth + 1, count + 1);
		selected[depth] = 0;
		dfs(depth + 1, count);
	}

	public static boolean isValid(int size) {
		boolean valid = false;

		for (int i = 1; i <= N; i++) {
			if (selected[i] == 1) {
				valid = bfs(i, size, 1);
				break;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (selected[i] == 0) {
				valid &= bfs(i, N - size, 0);
				break;
			}
		}

		return valid;
	}

	public static void calculate() {
		int sum = 0;

		for (int i = 1; i <= N; i++) {
			if (selected[i] == 1) {
				sum += population[i];
			}
		}

		int d = Math.abs(total - sum * 2);
		if (d < min)
			min = d;
	}

	public static boolean bfs(int node, int size, int select) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(node);
		int count = 1;

		boolean[] visited = new boolean[N + 1];
		visited[node] = true;

		while (!q.isEmpty()) {
			int index = q.poll();

			for (int i = 1; i <= N; i++) {
				if (visited[i])
					continue;

				if (map[index][i] == 1 && selected[i] == select) {
					visited[i] = true;
					q.add(i);
					count++;
				}
			}
		}
		return size == count;
	}

}