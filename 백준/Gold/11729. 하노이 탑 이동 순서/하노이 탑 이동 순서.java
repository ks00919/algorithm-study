import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

	static int K, count;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = parseInt(br.readLine());

		hanoi(K, 1, 2, 3);

		System.out.println(count);
		System.out.println(sb);
	}

	public static void hanoi(int n, int start, int mid, int to) {
		if (n == 1) {
			count++;
			sb.append(start).append(" ").append(to).append("\n");
			return;
		}

		hanoi(n - 1, start, to, mid);
		count++;
		sb.append(start).append(" ").append(to).append("\n");
		hanoi(n - 1, mid, start, to);
	}

}