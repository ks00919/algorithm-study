import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

	static int N, count;
	static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = parseInt(br.readLine());
		selected = new int[N];
		dfs(0);
		System.out.println(count);
	}

	public static void dfs(int depth) {
		if (depth == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isValidQ(depth, i)) {
				selected[depth] = i;
				dfs(depth + 1);
			}
		}
	}

	public static boolean isValidQ(int depth, int index) {
		int count = 0;
		for (int i = depth - 1; i >= 0; i--) {
			if (selected[i] == index || selected[i] == (index - ++count) || selected[i] == (index + count))
				return false;
		}
		return true;
	}

}