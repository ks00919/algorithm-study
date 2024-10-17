import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static List<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());
		int V = parseInt(st.nextToken());

		graph = new ArrayList[1001];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = parseInt(st.nextToken());
			int right = parseInt(st.nextToken());

			if (graph[left] == null)
				graph[left] = new ArrayList<>();

			if (graph[right] == null)
				graph[right] = new ArrayList<>();

			graph[left].add(right);
			graph[right].add(left);
		}

		for (int i = 0; i < graph.length; i++) {
			if (graph[i] != null)
				Collections.sort(graph[i]);
		}

		visited = new boolean[1001];
		dfs(V);
		sb.append("\n");

		visited = new boolean[1001];
		bfs(V);

		System.out.println(sb);
	}

	static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(" ");

		if (graph[v] == null)
			return;

		for (int number : graph[v]) {
			if (visited[number])
				continue;
			dfs(number);
		}
	}

	static void bfs(int v) {

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(v);

		while (!q.isEmpty()) {
			int number = q.poll();

			if (visited[number])
				continue;

			visited[number] = true;
			sb.append(number).append(" ");

			if (graph[number] == null)
				continue;

			for (int num : graph[number]) {
				q.offer(num);
			}

		}
	}
}
