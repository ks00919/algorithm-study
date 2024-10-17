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

		int N = parseInt(br.readLine());
		int C = parseInt(br.readLine());

		int[][] map = new int[N + 1][N + 1];

		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int from = parseInt(st.nextToken());
			int to = parseInt(st.nextToken());

			map[from][to] = 1;
			map[to][from] = 1;
		}

		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		int count = 0;
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;

		while (!q.isEmpty()) {
			int com = q.poll();

			for (int i = 1; i <= N; i++) {
				if (!visited[i] && map[com][i] == 1) {
					visited[i] = true;
					q.add(i);
					count++;
				}
			}
		}

		System.out.println(count);
	}
}