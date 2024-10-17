import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = parseInt(st.nextToken());
		int M = parseInt(st.nextToken());
		array = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = parseInt(st.nextToken());
			int b = parseInt(st.nextToken());

			if (array[a] == null)
				array[a] = new ArrayList<>();
			if (array[b] == null)
				array[b] = new ArrayList<>();

			array[a].add(b);
			array[b].add(a);
		}

		for (int i = 0; i <= N; i++) {
			dfs(N, 0, i);

			if (flag)
				break;
		}

		System.out.println(flag ? 1 : 0);
	}

	static boolean[] visited;
	static boolean flag;

	public static void dfs(int N, int depth, int node) {
		if (depth == 4) {
			flag = true;
			return;
		}

		if (array[node] == null || flag)
			return;

		visited[node] = true;
		for (int number : array[node]) {
			if (!visited[number])
				dfs(N, depth + 1, number);
		}
		visited[node] = false;
	}
}