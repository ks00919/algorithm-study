import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = parseInt(st.nextToken());
		int M = parseInt(st.nextToken());

		List<Integer>[] singers = new ArrayList[N + 1];
		int[] indegree = new int[N + 1];
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int prev = parseInt(st.nextToken());

			while (st.hasMoreTokens()) {
				int next = parseInt(st.nextToken());
				indegree[next]++;

				if (singers[prev] == null)
					singers[prev] = new ArrayList<>();

				singers[prev].add(next);
				prev = next;
			}

		}

		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}

		while (!q.isEmpty()) {
			int singer = q.poll();

			list.add(singer);

			if (singers[singer] == null)
				continue;

			for (int number : singers[singer]) {
				if (--indegree[number] == 0)
					q.add(number);
			}
		}

		if (list.size() != N) {
			System.out.println(0);
		} else {
			StringBuilder sb = new StringBuilder();
			for (int singer : list) {
				sb.append(singer).append("\n");
			}
			System.out.println(sb);
		}
	}

}
