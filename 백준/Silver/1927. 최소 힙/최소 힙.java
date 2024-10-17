import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = parseInt(br.readLine());
		Queue<Integer> q = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			int order = parseInt(br.readLine());

			if (order == 0) {
				if (q.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(q.poll()).append("\n");
			} else {
				q.add(order);
			}
		}
		System.out.println(sb);
	}
}