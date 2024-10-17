import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = parseInt(br.readLine());

		long[] memo = new long[n + 1];
		memo[1] = 1;
		for (int i = 2; i <= n; i++) {
			memo[i] = memo[i - 2] + memo[i - 1];
		}

		System.out.println(memo[n]);

	}
}